package com.multichoice.astar.impl;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IPathFinderFactory;
import com.multichoice.astar.IPathFinder;
import com.multichoice.constants.Constants;
import com.multichoice.map.IAreaMap;

public class PathFinderFactory implements IPathFinderFactory {
	private IPathFinder pathFinder;

	@Override
	public IPathFinder createPathFinder(String arg, IAreaMap map, IAStarHeuristic heuristic) {
		if (arg.equalsIgnoreCase(Constants.AstarAlgorithm)) {
			pathFinder = new AstarPathFinder(map, heuristic);
		}
		return pathFinder;
	}

}
