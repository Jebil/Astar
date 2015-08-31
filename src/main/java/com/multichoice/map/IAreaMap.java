package com.multichoice.map;

import java.util.ArrayList;

import com.multichoice.exceptions.NodeException;
import com.multichoice.node.INode;
import com.multichoice.node.coordinate.ICoordinate;

/**
 * Prototype for the AreaMap.
 * 
 * @author Jebil Kuruvila
 * 
 */
public interface IAreaMap {
	/**
	 * @throws NodeException
	 * 
	 *             Method to construct the AreaMap from 2D character array.
	 *             Converting symbols to nodes.
	 */
	public void createMap() throws NodeException;

	/**
	 * @param node
	 * @return
	 * 
	 * 		Method to get the neighbor list of a node. Considering the
	 *         allowDiagonalMove flag
	 */
	public ArrayList<INode> getNeighbourList(INode node);

	/**
	 * @return
	 * 
	 * 		Return the constructed map of nodes.
	 */
	public ArrayList<ArrayList<INode>> getNodes();

	/**
	 * @param coordinates
	 * @return
	 * 
	 * 		Method to get a particular node by its coordinates.
	 */
	public INode getNode(ICoordinate coordinates);

	/**
	 * @return
	 * 
	 * 		Method to return the start node
	 */
	public INode getStartNode();

	/**
	 * @return
	 * 
	 * 		Method to return the goal node.
	 */
	public INode getGoalNode();

	/**
	 * @throws NodeException
	 * 
	 *             Clear the map
	 */
	public void clear() throws NodeException;

	public int getMapWidth();

	public int getMapHeight();

}
