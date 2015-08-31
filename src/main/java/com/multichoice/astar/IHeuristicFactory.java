package com.multichoice.astar;

/**
 * @author Jebil Kuruvila
 *
 */
public interface IHeuristicFactory {
	/**
	 * @param arg
	 * @return
	 */
	public IAStarHeuristic createHeuristic(String arg);
}
