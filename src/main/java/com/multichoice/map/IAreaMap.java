package com.multichoice.map;

import java.util.ArrayList;

import com.multichoice.exceptions.NodeException;
import com.multichoice.node.INode;
import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 * 
 * 
 *         Prototype for the AreaMap.
 */
public interface IAreaMap {
	/**
	 * @throws NodeException
	 * 
	 */
	public void createMap() throws NodeException;

	/**
	 * @param node
	 * @return
	 */
	public ArrayList<INode> getNeighbourList(INode node);

	/**
	 * @return
	 */
	public ArrayList<ArrayList<INode>> getNodes();

	/**
	 * @param coordinates
	 * @return
	 */
	public INode getNode(ICoordinate coordinates);

	/**
	 * @return
	 */
	public INode getStartNode();

	/**
	 * @return
	 */
	public INode getGoalNode();

	/**
	 * @throws NodeException
	 * 
	 */
	public void clear() throws NodeException;

	/**
	 * @return
	 */
	public int getMapWidth();

	/**
	 * @return
	 */
	public int getMapHeight();

	/**
	 * @param value
	 */
	public void allowDiagonalMovement(boolean value);
}
