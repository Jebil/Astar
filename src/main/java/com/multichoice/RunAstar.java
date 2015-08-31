package com.multichoice;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.multichoice.astar.IAStarHeuristic;
import com.multichoice.astar.IPathFinder;
import com.multichoice.astar.IPathFinderFactory;
import com.multichoice.astar.impl.ManhattanHeuristic;
import com.multichoice.astar.impl.PathFinderFactory;
import com.multichoice.constants.Constants;
import com.multichoice.exceptions.NodeException;
import com.multichoice.file.ReadFile;
import com.multichoice.map.IAreaMap;
import com.multichoice.map.impl.AreaMap;

/**
 * Main class for running the program.
 * 
 * @author Jebil Kuruvila
 *
 */
public class RunAstar {
	private static IAreaMap map;
	private static IPathFinderFactory astarFactory;
	private static String inputFile = null;
	private static boolean allowDiagonal = true;
	static Logger log = Logger.getLogger(RunAstar.class.getName());

	public static void main(String[] args) {
		log.debug("Inside main function");
		astarFactory = new PathFinderFactory();
		readArgs(args); // Read the command line arguments to load inputFile
						// name and allowDiagonal indicator.
		try {
			// Creates new areaMap by generating character array from the file
			// and allowDiagonal flag
			map = new AreaMap(ReadFile.getFileAsCharArray(inputFile), allowDiagonal);

			log.debug("Setting diagonalMovementAllowed as " + allowDiagonal);

			// Create the instance of the required heuristic function.
			IAStarHeuristic heuristic = new ManhattanHeuristic();

			// Create the instance of path finder algorithm
			IPathFinder pathFinder = astarFactory.createPathFinder(Constants.AstarAlgorithm, map, heuristic);

			log.debug("Calculating shortest path.");
			pathFinder.calcShortestPath();

			log.debug("Printing the path.");
			pathFinder.printPath();

		} catch (NodeException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
			log.error("Please run as java -jar ${jar file name} [OPTIONS]");
			log.error("Append -f ${file} to specify the file or it'll search for map.txt in the same folder.");
			log.error("Append -d to prevent diagonal movement.");
		}
	}

	private static void readArgs(String[] args) {
		// Iterate through the command line arguments list
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-f")) {
				inputFile = args[i + 1];
			} else if (args[i].equalsIgnoreCase("-d")) {
				allowDiagonal = false;
			}
		}
	}
}
