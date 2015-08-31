package com.multichoice.astar.impl;

import org.apache.log4j.Logger;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IHeuristicFactory;
import com.multichoice.constants.Constants;

/**
 * @author Jebil Kuruvila
 *
 *         Factory implementation for generating Heuristic functions.
 */
public class HeuristicFactory implements IHeuristicFactory {
	private IAStarHeuristic heuristic;
	private static Logger logger = Logger.getLogger(HeuristicFactory.class);

	@Override
	public IAStarHeuristic createHeuristic(String arg) {
		if (arg.equalsIgnoreCase(Constants.ManhattanHeuristic)) {
			heuristic = new ManhattanHeuristic();
		}
		logger.debug("Creating instance of " + heuristic.getClass().getName() + " Using HeuristicFactory method");

		return heuristic;
	}
}
