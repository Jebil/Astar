package com.multichoice.node.impl;

import com.multichoice.enums.NodeType;
import com.multichoice.node.INode;
import com.multichoice.node.INodeFactory;
import com.multichoice.node.coordinate.impl.XYCoordinate;

public class NodeFactory implements INodeFactory {
	Node node;
	XYCoordinate coordinate;

	public INode createNode(XYCoordinate coordinate, int cost, NodeType type) {
		node = new Node(coordinate, cost, type);
		return node;
	}

}
