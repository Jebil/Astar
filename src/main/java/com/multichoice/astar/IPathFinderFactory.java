package com.multichoice.astar;

import com.multichoice.map.IAreaMap;

/**
 * @author Jebil Kuruvila
 *
 */
public interface IPathFinderFactory {
	/**
	 * @param arg
	 * @return
	 */
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic);

}
