package com.multichoice.map.impl;

import com.multichoice.exceptions.NodeException;
import com.multichoice.map.IAreaMap;
import com.multichoice.map.IAreaMapFactory;

public class AreaMapFactory implements IAreaMapFactory {
	IAreaMap areaMap;

	@Override
	public IAreaMap createAreaMap(char[][] map) throws NodeException {
		areaMap = new AreaMap(map);
		return areaMap;
	}

}
