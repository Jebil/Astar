package com.multichoice.astar;

import com.multichoice.map.IAreaMap;

/**
 * Factory for generating path finder algorithms.
 * 
 * @author Jebil Kuruvila
 *
 */
public interface IPathFinderFactory {

	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic);

}
