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
	private static Logger LOGGER = Logger.getLogger(RunAstar.class.getName());

	public static void main(String[] args) {
		IAreaMap map;
		String inputFile = null;
		IPathFinderFactory astarFactory;
		boolean allowDiagonal = true;
		LOGGER.debug("Inside main function");
		astarFactory = new PathFinderFactory();
		// Read the command line arguments to
		// load inputFile
		// name and allowDiagonal indicator.
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase(Constants.FILE_INPUT_OPTION)) {
				inputFile = args[i + 1];
			} else if (args[i].equalsIgnoreCase(Constants.ALLOW_DIAGONAL_FLAG)) {
				allowDiagonal = false;
			}
		}
		try {
			// Creates new areaMap by generating character array from the file
			// and allowDiagonal flag
			map = new AreaMap(ReadFile.getFileAsCharArray(inputFile), allowDiagonal);

			LOGGER.debug("Setting diagonalMovementAllowed as " + allowDiagonal);

			// Create the instance of the required heuristic function.
			IAStarHeuristic heuristic = new ManhattanHeuristic();

			// Create the instance of path finder algorithm
			IPathFinder pathFinder = astarFactory.createPathFinder(Constants.ASTAR_ALGORITHM, map, heuristic);

			LOGGER.debug("Calculating shortest path.");
			pathFinder.calcShortestPath();

			LOGGER.debug("Printing the path.");
			pathFinder.printPath();

		} catch (NodeException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("Please run as java -jar ${jar file name} [OPTIONS]");
			LOGGER.error("Append -f ${file} to specify the file or it'll search for map.txt in the same folder.");
			LOGGER.error("Append -d to prevent diagonal movement.");
		}
	}
}
