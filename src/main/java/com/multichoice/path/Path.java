package com.multichoice.path;

import java.util.ArrayList;

import com.multichoice.node.INode;
import com.multichoice.node.coordinate.impl.XYCoordinate;

/**
 * @author Jebil Kuruvila
 *
 */
public class Path {
	// The waypoints in the path (list of coordiantes making up the path)
	private ArrayList<INode> waypoints = new ArrayList<INode>();

	public Path() {
	}

	public int getLength() {
		return waypoints.size();
	}

	public INode getWayPoint(int index) {
		return waypoints.get(index);
	}

	/**
	 * Get the x-coordinate for the waypoiny at the given index.
	 * 
	 * @param index
	 *            The index of the waypoint to get the x-coordinate of.
	 * @return The x coordinate at the waypoint.
	 */
	public int getX(int index) {
		return ((XYCoordinate) getWayPoint(index).getCoordinates()).getX();
	}

	/**
	 * Get the y-coordinate for the waypoint at the given index.
	 * 
	 * @param index
	 *            The index of the waypoint to get the y-coordinate of.
	 * @return The y coordinate at the waypoint.
	 */
	public int getY(int index) {
		return ((XYCoordinate) getWayPoint(index).getCoordinates()).getY();
	}

	/**
	 * Append a waypoint to the path.
	 * 
	 * @param x
	 *            The x coordinate of the waypoint.
	 * @param y
	 *            The y coordinate of the waypoint.
	 */
	public void appendWayPoint(INode n) {
		waypoints.add(n);
	}

	/**
	 * Add a waypoint to the beginning of the path.
	 * 
	 * @param x
	 *            The x coordinate of the waypoint.
	 * @param y
	 *            The y coordinate of the waypoint.
	 */
	public void prependWayPoint(INode n) {
		waypoints.add(0, n);
	}

	/**
	 * Check if this path contains the WayPoint
	 * 
	 * @param x
	 *            The x coordinate of the waypoint.
	 * @param y
	 *            The y coordinate of the waypoint.
	 * @return True if the path contains the waypoint.
	 */
	public boolean contains(XYCoordinate coordinate) {
		for (INode node : waypoints) {
			if (coordinate.equals(node.getCoordinates()))
				return true;
		}
		return false;
	}
}
