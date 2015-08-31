/**
 * 
 */
package com.multichoice.astar;

import com.multichoice.node.coordinate.ICoordinate;

/**
 * Used to calculate estimated distance between two nodes.
 * 
 * @author Jebil Kuruvila
 * 
 * 
 * 
 */
public interface IAStarHeuristic {

	public float getEstimatedDistanceToGoal(ICoordinate start, ICoordinate goal);

}
