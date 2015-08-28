package com.multichoice.node;

import com.multichoice.constants.Constants;
import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.XYCoordinate;

public class NodeFactory implements INodeFactory {
	Node node;
	XYCoordinate coordinate;

	public INode newStartNode(int... coordinates) {
		node = new Node();
		coordinate = new XYCoordinate();
		coordinate.setCoordinates(coordinates);
		node.setCoordinate(coordinate);
		node.setCost(Constants.costFlatland);
		node.setType(NodeType.START);
		return node;
	}

	public INode newObstacleNode(int... coordinates) {
		node = new Node();
		coordinate = new XYCoordinate();
		coordinate.setCoordinates(coordinates);
		node.setCoordinate(coordinate);
		node.setType(NodeType.OBSTACLE);
		node.setCost(0);
		return node;
	}

	public INode newGoalNode(int... coordinates) {
		node = new Node();
		coordinate = new XYCoordinate();
		coordinate.setCoordinates(coordinates);
		node.setCoordinate(coordinate);
		node.setCost(Constants.costFlatland);
		node.setType(NodeType.GOAL);
		return node;
	}

	public INode newOtherNode(int cost, int... coordinates) {
		node = new Node();
		coordinate = new XYCoordinate();
		coordinate.setCoordinates(coordinates);
		node.setCoordinate(coordinate);
		node.setCost(cost);
		node.setType(NodeType.OTHER);
		return node;
	}

}
