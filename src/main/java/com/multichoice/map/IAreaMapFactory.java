package com.multichoice.map;

import com.multichoice.exceptions.NodeException;

/**
 * @author Jebil Kuruvila
 *
 *
 *         Prototype for the AreaMap factory
 */
public interface IAreaMapFactory {
	/**
	 * @param map
	 * @return
	 * @throws NodeException
	 */
	public IAreaMap createAreaMap(char[][] map) throws NodeException;
}
