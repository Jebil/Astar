package com.test.node.coordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.multichoice.node.coordinate.impl.XYCoordinate;

public class CoordinateTest {
	@Test
	public void checkXYCoordinates() {
		XYCoordinate coordinate = new XYCoordinate(10,5);
		XYCoordinate coordinate1 = new XYCoordinate(10,5);
		assertEquals(coordinate.getX(), 10);
		assertEquals(coordinate.getY(), 5);
		assertEquals(coordinate, coordinate1);
		assertTrue(coordinate.equals(coordinate1));
		coordinate1.setCoordinates(10, 10);
		assertFalse(coordinate.equals(coordinate1));
	}
}
