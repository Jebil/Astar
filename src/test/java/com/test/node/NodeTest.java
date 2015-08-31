package com.test.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.multichoice.enums.NodeType;
import com.multichoice.node.INode;
import com.multichoice.node.INodeFactory;
import com.multichoice.node.coordinate.impl.XYCoordinate;
import com.multichoice.node.impl.NodeFactory;

public class NodeTest {
	INodeFactory factory;
	INode node;

	@Test
	public void checkNodeFactory() {
		factory = new NodeFactory();
		node = factory.createNode(new XYCoordinate(5, 5), 2, NodeType.FOREST);
		assertNotNull(node);
		assertEquals(node.getCoordinates(), new XYCoordinate(5, 5));
		assertEquals(node.getCost(), 2);
		assertEquals(node.getType(), NodeType.FOREST);
	}

}
