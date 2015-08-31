package com.multichoice.astar;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Factory for creating Heuiristic functions.
 */
public interface IHeuristicFactory {

	public IAStarHeuristic createHeuristic(String arg);

}
