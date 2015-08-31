package com.multichoice.map.impl;

import org.apache.log4j.Logger;

import com.multichoice.exceptions.NodeException;
import com.multichoice.map.IAreaMap;
import com.multichoice.map.IAreaMapFactory;

public class AreaMapFactory implements IAreaMapFactory {
	private IAreaMap areaMap;
	private static Logger logger = Logger.getLogger(AreaMapFactory.class);

	@Override
	public IAreaMap createAreaMap(char[][] map) throws NodeException {
		logger.debug("Creating new AreaMap via AreaMapFactory.");
		areaMap = new AreaMap(map);
		return areaMap;
	}

}
