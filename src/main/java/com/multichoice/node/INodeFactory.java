package com.multichoice.node;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 *
 */
public interface INodeFactory {

	/**
	 * @param coordinate
	 * @param cost
	 * @param type
	 * @return
	 */
	public INode createNode(ICoordinate coordinate, int cost, NodeType type);
}
