package com.multichoice.astar;

import com.multichoice.map.IAreaMap;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Factory for generating path finder algorithms.
 */
public interface IPathFinderFactory {
	
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic);

}
