package com.multichoice.astar.impl;

import java.io.FileWriter;
import static com.multichoice.constants.Constants.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IPathFinder;
import com.multichoice.enums.NodeType;
import com.multichoice.exceptions.NoPathFoundException;
import com.multichoice.exceptions.NodeException;
import com.multichoice.file.ReadFile;
import com.multichoice.map.IAreaMap;
import com.multichoice.node.INode;
import com.multichoice.node.coordinate.impl.XYCoordinate;
import com.multichoice.path.Path;

/**
 * Responsible for calculating the shortest path.
 * 
 * @author Jebil Kuruvila
 */
public class AstarPathFinder implements IPathFinder {
	private IAreaMap map;
	private IAStarHeuristic heuristic;
	private ArrayList<INode> closedList;
	private SortedNodeList openList;
	private Path shortestPath;
	private float estimatedDistanceToGoal;
	private static Logger LOGGER = Logger.getLogger(AstarPathFinder.class);

	/**
	 * @param map
	 * @param heuristic
	 * 
	 *            Constructor method to initialize the map and setting the
	 *            desired heuristic function.
	 */
	protected AstarPathFinder(IAreaMap map, IAStarHeuristic heuristic) {
		LOGGER.debug(
				"Creating instance of AstarPathFinder. With heuristic function as " + heuristic.getClass().getName());
		this.map = map;
		this.heuristic = heuristic;
		closedList = new ArrayList<INode>();
		openList = new SortedNodeList();
	}

	/**
	 * @return
	 * 
	 * 		Method to calculate the shortest and low cost path.
	 * @throws NodeException
	 */
	public Path calcShortestPath() throws NodeException {
		map.getStartNode().setCostFromStart(0);
		closedList.clear();
		openList.clear();
		openList.add(map.getStartNode());
		// while we haven't reached the goal yet
		while (openList.size() != 0) {
			// get the first Node from non-searched Node list, sorted by lowest
			// distance from our goal as guessed by our heuristic
			INode current = openList.getFirst();

			// check if our current Node location is the goal Node. If it is, we
			// are done.
			if (current.getCoordinates().equals(map.getGoalNode().getCoordinates())) {
				return reconstructPath(current);
			}

			// move current Node to the closed (already searched) list
			openList.remove(current);
			closedList.add(current);

			// go through all the current Nodes neighbors and calculate if one
			// should be our next step
			for (INode neighbor : map.getNeighbourList(current)) {
				// if we have already searched this Node, don't bother and
				// continue to the next one
				if (closedList.contains(neighbor))
					continue;
				// also just continue if the neighbor is an obstacle
				if (!neighbor.getType().equals(NodeType.OBSTACLE)) {
					// calculate how long the path is if we choose this neighbor
					// as the next step in the path
					float neighborCostFromStart = (current.getCostFromStart() + neighbor.getCost());
					// add neighbor to the open list if it is not there
					if (!openList.contains(neighbor)) {
						openList.add(neighbor);
						setNeighbourParams(current, neighbor, neighborCostFromStart);
						// if neighbor is closer to start it could also be
						// better
					} else if (neighborCostFromStart < current.getCostFromStart()) {
						// set neighbors parameters if it is better
						setNeighbourParams(current, neighbor, neighborCostFromStart);
					}
				}
			}
		}
		if (shortestPath == null) {
			LOGGER.debug("No solution found.");
			throw new NoPathFoundException();
		}

		return shortestPath;

	}

	/**
	 * @param current
	 * @param neighbor
	 * @param neighborCostFromStart
	 * 
	 *            Method to set neighbors parameters if it is better.
	 */
	private void setNeighbourParams(INode current, INode neighbor, float neighborCostFromStart) {
		// Set the previous node as current.
		neighbor.setPreviousNode(current);
		// Set the cost from start as calculated before.
		neighbor.setCostFromStart(neighborCostFromStart);
		// Find estimated distance to goal using provided heuristic function.
		estimatedDistanceToGoal = heuristic.getEstimatedDistanceToGoal(neighbor.getCoordinates(),
				map.getGoalNode().getCoordinates());
		// Set the heuristic cost to the neighbor.
		neighbor.setHeuristicCostFromGoal(estimatedDistanceToGoal + neighbor.getCost());
	}

	/**
	 * @param node
	 * @return
	 * 
	 * 		Method to construct the path on finding the goal node traversing
	 *         from the start node.
	 * @throws Exception
	 */
	private Path reconstructPath(INode node) throws NodeException {
		LOGGER.debug("Goal node found, constructing the path.");
		map.clear();
		int cost = 0;
		// New path instance.
		Path path = new Path();
		while (null != node.getPreviousNode()) {
			cost += node.getCost();
			path.prependWayPoint(node);
			node = node.getPreviousNode();
		}
		LOGGER.debug("Cost for this path is " + cost);
		this.shortestPath = path;
		return path;
	}

	/**
	 * @throws IOException
	 * 
	 *             Print the the found out path to console/ file.
	 */
	public void printPath() throws IOException {
		FileWriter fw = ReadFile.getFileWriter();
		INode node;
		for (int x = 0; x < map.getMapWidth(); x++) {
			for (int y = 0; y < map.getMapHeight(); y++) {

				node = map.getNode(new XYCoordinate(x, y));

				if (node.getType().equals(NodeType.OBSTACLE)) {
					fw.write(obstacleNode);
					System.out.print(obstacleNode);
				} else if (node.getType().equals(NodeType.START)) {
					fw.write(pathSymbol);
					System.out.print(pathSymbol);
				} else if (node.getType().equals(NodeType.GOAL)) {
					fw.write(pathSymbol);
					System.out.print(pathSymbol);
				} else if (shortestPath.contains(new XYCoordinate(x, y))) {
					fw.write(pathSymbol);
					System.out.print(pathSymbol);
				} else {
					if (node.getCost() == costFlatland) {
						fw.write(flatLand);
						System.out.print(flatLand);
					} else if (node.getCost() == costForest) {
						fw.write(forestNode);
						System.out.print(forestNode);
					} else if (node.getCost() == costMountain) {
						fw.write(mountain);
						System.out.print(mountain);
					}
				}
			}
			fw.write(System.getProperty("line.separator"));
			System.out.println();
		}
		fw.flush();
	}

	/**
	 * @author Jebil Kuruvila
	 * 
	 *         Class to maintain a sorted list of nodes.
	 *
	 */
	private class SortedNodeList {

		private ArrayList<INode> list = new ArrayList<INode>();

		public INode getFirst() {
			return list.get(0);
		}

		public void clear() {
			list.clear();
		}

		public void add(INode node) {
			list.add(node);
			Collections.sort(list);
		}

		public void remove(INode n) {
			list.remove(n);
		}

		public int size() {
			return list.size();
		}

		public boolean contains(INode n) {
			return list.contains(n);
		}
	}
}
