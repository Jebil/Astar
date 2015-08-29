package com.multichoice.node;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.impl.XYCoordinate;

public interface INodeFactory {

	public INode createNode(XYCoordinate coordinate, int cost, NodeType type);
}
