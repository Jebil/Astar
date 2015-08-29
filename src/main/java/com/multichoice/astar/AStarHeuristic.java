/**
 * 
 */
package com.multichoice.astar;

import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 *
 */
public interface AStarHeuristic {
	/**
	 * @param startX
	 * @param startY
	 * @param goalX
	 * @param goalY
	 * @return
	 */
	public float getEstimatedDistanceToGoal(ICoordinate start, ICoordinate goal);
}
