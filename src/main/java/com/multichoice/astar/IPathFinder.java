package com.multichoice.astar;

import java.io.IOException;

import com.multichoice.exceptions.NodeException;
import com.multichoice.path.Path;

/**
 * @author Jebil Kuruvila
 *
 */
public interface IPathFinder {
	/**
	 * @return
	 * @throws NodeException
	 */
	public Path calcShortestPath() throws NodeException;

	/**
	 * @throws IOException
	 */
	public void printPath() throws IOException;
}
