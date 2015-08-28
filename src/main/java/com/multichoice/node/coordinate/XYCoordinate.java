package com.multichoice.node.coordinate;

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

	public void setCoordinates(int... x) {
		this.x = x[0];
		this.y = x[1];
	}

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
}
