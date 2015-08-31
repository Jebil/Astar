package com.multichoice.astar.impl;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IHeuristicFactory;
import com.multichoice.constants.Constants;

public class HeuristicFactory implements IHeuristicFactory {
	private IAStarHeuristic heuristic;

	@Override
	public IAStarHeuristic createHeuristic(String arg) {
		if (arg.equalsIgnoreCase(Constants.ManhattanHeuristic)) {
			heuristic = new ManhattanHeuristic();
		}
		return heuristic;
	}
}
