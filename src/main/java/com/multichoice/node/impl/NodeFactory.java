package com.multichoice.node.impl;

import com.multichoice.enums.NodeType;
import com.multichoice.node.INode;
import com.multichoice.node.INodeFactory;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.impl.XYCoordinate;

/**
 * Implementation of NodeFactory.
 * 
 * @author Jebil Kuruvila
 *
 */
public class NodeFactory implements INodeFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multichoice.node.INodeFactory#createNode(com.multichoice.node.
	 * coordinate.ICoordinate, int, com.multichoice.enums.NodeType)
	 */
	public INode createNode(ICoordinate coordinate, int cost, NodeType type) {
		INode node = new Node((XYCoordinate) coordinate, cost, type);
		return node;
	}

}
