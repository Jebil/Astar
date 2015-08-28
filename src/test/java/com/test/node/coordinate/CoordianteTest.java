package com.test.node.coordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.multichoice.node.coordinate.XYCoordinate;

public class CoordianteTest {
	@Test
	public void checkXYCoordinates() {
		XYCoordinate coordinate = new XYCoordinate();
		XYCoordinate coordinate1 = new XYCoordinate();
		coordinate.setCoordinates(10, 5);
		coordinate1.setCoordinates(10, 5);
		assertEquals(coordinate.getCoordinates().getX(), 10);
		assertEquals(coordinate.getCoordinates().getY(), 5);
		assertEquals(coordinate, coordinate1);
		assertTrue(coordinate.equals(coordinate1));
		coordinate1.setCoordinates(10, 10);
		assertFalse(coordinate.equals(coordinate1));
	}
}
