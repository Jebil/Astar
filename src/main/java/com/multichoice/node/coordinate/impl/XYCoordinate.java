package com.multichoice.node.coordinate.impl;

import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 *
 *         Two dimensional implementation for the ICoordinate.
 */
public class XYCoordinate implements ICoordinate {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public XYCoordinate getCoordinates() {
		return this;
	}

	public XYCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setCoordinates(int... x) {
		this.x = x[0];
		this.y = x[1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == XYCoordinate.class) {
			XYCoordinate coord = (XYCoordinate) obj;
			if (this.x == coord.getX() && this.y == coord.getY()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "X=" + this.x + ", Y=" + this.y;
	}
}
