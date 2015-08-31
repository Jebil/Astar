package com.multichoice.astar;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Factory for creating Heuiristic functions.
 */
public interface IHeuristicFactory {
	/**
	 * @param arg
	 * @return
	 */
	public IAStarHeuristic createHeuristic(String arg);
}
