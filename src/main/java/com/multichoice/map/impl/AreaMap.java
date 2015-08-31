package com.multichoice.map.impl;

import java.util.ArrayList;
import static com.multichoice.constants.Constants.*;

import org.apache.log4j.Logger;

import com.multichoice.constants.Constants;
import com.multichoice.enums.NodeType;
import com.multichoice.exceptions.MultipleGoalNodesFoundException;
import com.multichoice.exceptions.MultipleStartNodesFoundException;
import com.multichoice.exceptions.NoStartNodeException;
import com.multichoice.exceptions.NodeException;
import com.multichoice.map.IAreaMap;
import com.multichoice.node.INode;
import com.multichoice.node.INodeFactory;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.impl.XYCoordinate;
import com.multichoice.node.impl.NodeFactory;

/**
 * Type for doing the whole operations Converting the 2D character map into
 * ArrayList[ArrayList[INode]] for easier management.
 * 
 * @author Jebil Kuruvila
 *
 */
public class AreaMap implements IAreaMap {
	private int mapWidth;
	private int mapHeight;
	private ArrayList<ArrayList<INode>> map;
	private XYCoordinate startLocation = null;
	private XYCoordinate goalLocation = null;
	private char[][] charMap;
	private INodeFactory nodeFactory;
	private ArrayList<INode> neighbourList;
	private XYCoordinate coordinate;
	private int x, y;
	private boolean allowDiagonalMovement = true;
	private static Logger LOGGER = Logger.getLogger(AreaMap.class);

	/**
	 * @param charArray
	 * @param diagonalMovement
	 * @throws NodeException
	 * 
	 *             Constructor method to create and initialize instance with raw
	 *             2D character array and diagonal movement flag
	 */
	public AreaMap(char[][] charArray, boolean diagonalMovement) throws NodeException {
		this.mapWidth = charArray.length;
		this.mapHeight = charArray[0].length;
		this.charMap = charArray;
		this.allowDiagonalMovement = diagonalMovement;
		LOGGER.debug("Creating new instance of AreaMap with map width as " + mapWidth + " and height as " + mapHeight);
		createMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multichoice.map.IAreaMap#createMap()
	 */
	public void createMap() throws NodeException {
		INode node = null;
		map = new ArrayList<ArrayList<INode>>();
		nodeFactory = new NodeFactory();
		for (int x = 0; x < mapWidth; x++) {
			map.add(new ArrayList<INode>());
			for (int y = 0; y < mapHeight; y++) {
				switch (charMap[x][y]) {
				case obstacleNode:
					node = nodeFactory.createNode(new XYCoordinate(x, y), 0, NodeType.OBSTACLE);
					break;
				case flatLand:
					node = nodeFactory.createNode(new XYCoordinate(x, y), Constants.costFlatland, NodeType.OTHER);
					break;
				case startNode:
					if (null != startLocation)
						throw new MultipleStartNodesFoundException();
					startLocation = new XYCoordinate(x, y);
					node = nodeFactory.createNode(startLocation, Constants.costFlatland, NodeType.START);
					break;
				case goalNode:
					if (null != goalLocation)
						throw new MultipleGoalNodesFoundException();
					goalLocation = new XYCoordinate(x, y);
					node = nodeFactory.createNode(goalLocation, Constants.costFlatland, NodeType.GOAL);
					break;
				case forestNode:
					node = nodeFactory.createNode(new XYCoordinate(x, y), Constants.costForest, NodeType.OTHER);
					break;
				case mountain:
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multichoice.map.IAreaMap#getNeighbourList(com.multichoice.node.INode)
	 */
	public ArrayList<INode> getNeighbourList(INode node) {

		neighbourList = new ArrayList<INode>();
		coordinate = (XYCoordinate) node.getCoordinates();
		x = coordinate.getX();
		y = coordinate.getY();

		if (!(y == 0))
			neighbourList.add(map.get(x).get(y - 1));
		if (!(x == mapWidth - 1))
			neighbourList.add(map.get(x + 1).get(y));
		if (!(x == 0))
			neighbourList.add(map.get(x - 1).get(y));
		if (!(y == mapHeight - 1))
			neighbourList.add(map.get(x).get(y + 1));

		if (allowDiagonalMovement) {
			if (!(y == 0) && !(x == mapWidth - 1))
				neighbourList.add(map.get(x + 1).get(y - 1));
			if (!(x == 0) && !(y == mapHeight - 1))
				neighbourList.add(map.get(x - 1).get(y + 1));
			if (!(x == 0) && !(y == 0))
				neighbourList.add(map.get(x - 1).get(y - 1));
			if (!(x == mapWidth - 1) && !(y == mapHeight - 1))
				neighbourList.add(map.get(x + 1).get(y + 1));
		}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multichoice.map.IAreaMap#clear()
	 */
	public void clear() throws NodeException {
		startLocation = null;
		goalLocation = null;
		createMap();
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

}
