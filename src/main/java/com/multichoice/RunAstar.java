package com.multichoice;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IHeuristicFactory;
import com.multichoice.astar.IPathFinder;
import com.multichoice.astar.IPathFinderFactory;
import com.multichoice.astar.impl.HeuristicFactory;
import com.multichoice.astar.impl.PathFinderFactory;
import com.multichoice.constants.Constants;
import com.multichoice.exceptions.NodeException;
import com.multichoice.file.ReadFile;
import com.multichoice.map.IAreaMap;
import com.multichoice.map.IAreaMapFactory;
import com.multichoice.map.impl.AreaMapFactory;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Main class for running the program.
 */
public class RunAstar {
	private static IAreaMapFactory areaMapFactory;
	private static IAreaMap map;
	private static IPathFinderFactory astarFactory;
	private static IHeuristicFactory heuristicFactory;
	private static String inputFile = null;
	private static boolean allowDiagonal = true;
	static Logger log = Logger.getLogger(RunAstar.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.debug("Inside main function");
		areaMapFactory = new AreaMapFactory();
		astarFactory = new PathFinderFactory();
		heuristicFactory = new HeuristicFactory();
		readArgs(args);
		try {
			map = areaMapFactory.createAreaMap(ReadFile.getFileAsCharArray(inputFile));

			log.debug("Setting diagonalMovementAllowed as " + allowDiagonal);
			map.allowDiagonalMovement(allowDiagonal);

			IAStarHeuristic heuristic = heuristicFactory.createHeuristic(Constants.ManhattanHeuristic);

			IPathFinder pathFinder = astarFactory.createPathFinder(Constants.AstarAlgorithm, map, heuristic);

			log.debug("Calculating shortest path.");
			pathFinder.calcShortestPath();

			log.debug("Printing the path.");
			pathFinder.printPath();

		} catch (NodeException | IOException e) {
			log.error(e.getMessage());
		}
	}

	private static void readArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-f")) {
				inputFile = args[i + 1];
			} else if (args[i].equalsIgnoreCase("-d")) {
				allowDiagonal = false;
			}
		}
	}
}
