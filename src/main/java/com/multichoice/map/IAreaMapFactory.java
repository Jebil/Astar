package com.multichoice.map;

import com.multichoice.exceptions.NodeException;

/**
 * Prototype for the AreaMap factory
 * 
 * @author Jebil Kuruvila
 *
 *
 */
public interface IAreaMapFactory {
	/**
	 * @param map
	 * @return
	 * @throws NodeException
	 */
	public IAreaMap createAreaMap(char[][] map, boolean diagonalMovement) throws NodeException;

}
