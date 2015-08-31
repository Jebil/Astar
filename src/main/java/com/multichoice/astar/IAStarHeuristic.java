/**
 * 
 */
package com.multichoice.astar;

import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 * 
 * 
 *         Used to calculate estimated distance between two nodes.
 */
public interface IAStarHeuristic {

	public float getEstimatedDistanceToGoal(ICoordinate start, ICoordinate goal);

}
