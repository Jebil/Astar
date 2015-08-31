package com.multichoice.astar.impl;

import org.apache.log4j.Logger;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IPathFinderFactory;
import com.multichoice.astar.IPathFinder;
import com.multichoice.constants.Constants;
import com.multichoice.map.IAreaMap;

/**
 * Factory implementation for creating path finder algorithm.
 * 
 * @author Jebil Kuruvila
 * 
 */
public class PathFinderFactory implements IPathFinderFactory {
	private static Logger LOGGER = Logger.getLogger(PathFinderFactory.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multichoice.astar.IPathFinderFactory#createPathFinder(java.lang.
	 * String, com.multichoice.map.IAreaMap,
	 * com.multichoice.astar.IAStarHeuristic)
	 */
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic) {
		IPathFinder pathFinder = null;
		if (arg.equalsIgnoreCase(Constants.ASTAR_ALGORITHM)) {
			pathFinder = new AstarPathFinder(map, heuristic);
		}
		LOGGER.debug("Creating new instance of " + pathFinder.getClass().getName() + " Using PathFinderFactory");
		return pathFinder;
	}

}
