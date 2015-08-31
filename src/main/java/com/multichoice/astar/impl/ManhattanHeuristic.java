package com.multichoice.astar.impl;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.impl.XYCoordinate;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Implementation of AStarHeuristic interface using Manhattan distance
 *         formula |x1 - x2| + |y1 - y2|
 */
public class ManhattanHeuristic implements IAStarHeuristic {
	int startX, startY, goalX, goalY;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.multichoice.astar.IAStarHeuristic#getEstimatedDistanceToGoal(com.
	 * multichoice.node.coordinate.ICoordinate,
	 * com.multichoice.node.coordinate.ICoordinate)
	 */
	public float getEstimatedDistanceToGoal(ICoordinate start, ICoordinate goal) {
		startX = ((XYCoordinate) start).getX();
		startY = ((XYCoordinate) start).getY();
		goalX = ((XYCoordinate) goal).getX();
		goalY = ((XYCoordinate) goal).getY();
		return (Math.abs(startX - goalX) + Math.abs(startY - goalY));
	}

	/**
	 * Making the constructor available only for factory.
	 */
	protected ManhattanHeuristic() {
	}
}
