package com.multichoice.node.coordinate;

/**
 * Type for holding the coordinates of the Node.
 * 
 * @author Jebil Kuruvila
 *
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
