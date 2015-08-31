package com.multichoice.node.coordinate;

/**
 * @author Jebil Kuruvila
 *
 * 
 *         Type for holding the coordinates of the Node.
 */
public interface ICoordinate {
	/**
	 * @return
	 */
	ICoordinate getCoordinates();

	/**
	 * @param x
	 */
	void setCoordinates(int... x);
}
