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
	private IPathFinder pathFinder;
	private static Logger logger = Logger.getLogger(PathFinderFactory.class);

	@Override
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic) {
		if (arg.equalsIgnoreCase(Constants.AstarAlgorithm)) {
			pathFinder = new AstarPathFinder(map, heuristic);
		}
		logger.debug("Creating new instance of " + pathFinder.getClass().getName() + " Using PathFinderFactory");
		return pathFinder;
	}

}
