package com.multichoice.astar;

import java.io.IOException;

import com.multichoice.exceptions.NodeException;
import com.multichoice.path.Path;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Prototype for path finding algorithm.
 */
public interface IPathFinder {
	/**
	 * @return
	 * @throws NodeException
	 * 
	 *             Find the Shortest and low cost path
	 */
	public Path calcShortestPath() throws NodeException;

	/**
	 * @throws IOException
	 * 
	 *             Print the identified path
	 */
	public void printPath() throws IOException;
}
