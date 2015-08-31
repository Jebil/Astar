package com.multichoice;

import java.io.IOException;

import com.multichoice.astar.AStarHeuristic;
import com.multichoice.astar.Astar;
import com.multichoice.astar.DistanceHeuristic;
import com.multichoice.file.ReadFile;
import com.multichoice.map.impl.AreaMap;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Main class for running the program.
 */
public class RunAstar {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		ReadFile readFile = new ReadFile();

		AreaMap map = new AreaMap(readFile.getFileAsCharArray());

		map.allowDiagonalMovement(true);

		AStarHeuristic heuristic = new DistanceHeuristic();

		Astar pathFinder = new Astar(map, heuristic);

		pathFinder.calcShortestPath();

		pathFinder.printPath();
	}
}
