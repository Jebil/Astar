package com.multichoice.astar;

import com.multichoice.map.IAreaMap;

/**
 * Factory for generating path finder algorithms.
 * 
 * flexible enough to accommodate different types of algorithm
 * 
 * @author Jebil Kuruvila
 *
 */
public interface IPathFinderFactory {

	/**
	 * Flexible enough to accommodate different types of algorithm
	 * 
	 * @param arg
	 * @param map
	 * @param heuristic
	 * @return
	 */
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic);

}
