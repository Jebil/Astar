package com.multichoice.map.impl;

import java.util.ArrayList;

import com.multichoice.constants.Constants;
import com.multichoice.enums.NodeType;
import com.multichoice.exceptions.MultipleGoalNodesFoundException;
import com.multichoice.exceptions.MultipleStartNodesFoundException;
import com.multichoice.exceptions.NoStartNodeException;
import com.multichoice.map.IAreaMap;
import com.multichoice.node.INode;
import com.multichoice.node.INodeFactory;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.impl.XYCoordinate;
import com.multichoice.node.impl.NodeFactory;

/**
 * @author Jebil Kuruvila
 *
 */
public class AreaMap implements IAreaMap {
	private int mapWidth;
	private int mapHeight;
	private ArrayList<ArrayList<INode>> map;
	private XYCoordinate startLocation = null;
	private XYCoordinate goalLocation = null;
	private char[][] obstacleMap;
	private INodeFactory nodeFactory;
	private ArrayList<INode> neighbourList;
	private XYCoordinate coordinate;
	private int x, y;
	private boolean allowDiagonalMovement = true;

	public AreaMap(char[][] obstacleMap) throws Exception {
		this.mapWidth = obstacleMap.length;
		this.mapHeight = obstacleMap[0].length;
		this.obstacleMap = obstacleMap;
		createMap();
	}

	public void createMap() throws Exception {
		INode node = null;
		map = new ArrayList<ArrayList<INode>>();
		nodeFactory = new NodeFactory();
		for (int x = 0; x < mapWidth; x++) {
			map.add(new ArrayList<INode>());
			for (int y = 0; y < mapHeight; y++) {
				switch (obstacleMap[x][y]) {
				case '~':
					node = nodeFactory.createNode(new XYCoordinate(x, y), 0, NodeType.OBSTACLE);
					break;
				case '.':
					node = nodeFactory.createNode(new XYCoordinate(x, y), Constants.costFlatland, NodeType.OTHER);
					break;
				case '@':
					if (null != startLocation)
						throw new MultipleStartNodesFoundException();
					startLocation = new XYCoordinate(x, y);
					node = nodeFactory.createNode(startLocation, Constants.costFlatland, NodeType.START);
					break;
				case 'X':
					if (null != goalLocation)
						throw new MultipleGoalNodesFoundException();
					goalLocation = new XYCoordinate(x, y);
					node = nodeFactory.createNode(goalLocation, Constants.costFlatland, NodeType.GOAL);
					break;
				case '*':
					node = nodeFactory.createNode(new XYCoordinate(x, y), Constants.costForest, NodeType.OTHER);
					break;
				case '^':
					node = nodeFactory.createNode(new XYCoordinate(x, y), Constants.costMountain, NodeType.OTHER);
					break;
				}
				map.get(x).add(node);
			}
		}
		if (null == startLocation) {
			throw new NoStartNodeException();
		}
		if (null == goalLocation) {
			throw new NoStartNodeException();
		}
	}

	public ArrayList<INode> getNeighbourList(INode node) {

		neighbourList = new ArrayList<INode>();
		coordinate = (XYCoordinate) node.getCoordinates();
		x = coordinate.getX();
		y = coordinate.getY();
		if (!(y == 0))
			neighbourList.add(map.get(x).get(y - 1));
		if (!(y == 0) && !(x == mapWidth - 1) && allowDiagonalMovement)
			neighbourList.add(map.get(x + 1).get(y - 1));
		if (!(x == mapWidth - 1))
			neighbourList.add(map.get(x + 1).get(y));
		if (!(x == mapWidth - 1) && !(y == mapHeight - 1) && allowDiagonalMovement)
			neighbourList.add(map.get(x + 1).get(y + 1));
		if (!(y == mapHeight - 1))
			neighbourList.add(map.get(x).get(y + 1));
		if (!(x == 0) && !(y == mapHeight - 1) && allowDiagonalMovement)
			neighbourList.add(map.get(x - 1).get(y + 1));
		if (!(x == 0))
			neighbourList.add(map.get(x - 1).get(y));
		if (!(x == 0) && !(y == 0) && allowDiagonalMovement)
			neighbourList.add(map.get(x - 1).get(y - 1));

		return neighbourList;
	}

	public ArrayList<ArrayList<INode>> getNodes() {
		return map;
	}

	public INode getNode(ICoordinate coordinates) {
		coordinate = (XYCoordinate) coordinates;
		return map.get(coordinate.getX()).get(coordinate.getY());
	}

	public INode getStartNode() {
		return map.get(startLocation.getX()).get(startLocation.getY());
	}

	public INode getGoalNode() {
		return map.get(goalLocation.getX()).get(goalLocation.getY());
	}

	public void clear() throws Exception {
		startLocation = null;
		goalLocation = null;
		createMap();
	}

	// public float getDistanceBetween(INode node1, INode node2) {
	// XYCoordinate node1Coordinates = (XYCoordinate) node1.getCoordinates();
	// XYCoordinate node2Coordinates = (XYCoordinate) node2.getCoordinates();
	// // if the nodes are on top or next to each other
	// if (node1Coordinates.getX() == node2Coordinates.getX() ||
	// node1Coordinates.getY() == node2Coordinates.getY()) {
	// return 1 * (mapHeight + mapWidth);
	// } else { // if they are diagonal to each other return diagonal distance:
	// return (float) 1.7 * (mapHeight + mapWidth);
	// }
	// }

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	@Override
	public void allowDiagonalMovement(boolean value) {
		this.allowDiagonalMovement = value;
	}

}
