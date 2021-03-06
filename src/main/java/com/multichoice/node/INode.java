package com.multichoice.node;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.ICoordinate;

/**
 * Type for storing each tile data in the map
 * 
 * @author Jebil Kuruvila
 *
 */
public interface INode extends Comparable<INode> {
	/**
	 * @return
	 * 
	 * 		Gets the type of tile (Obstacle, Start, Goal, Other)
	 */
	public NodeType getType();

	/**
	 * @return
	 */
	public ICoordinate getCoordinates();

	/**
	 * @return
	 * 
	 * 		Reference to the previous node to maintain the path
	 */
	public INode getPreviousNode();

	/**
	 * @param previousNode
	 */
	public void setPreviousNode(INode previousNode);

	/**
	 * Get the estimatedDistance to goal as calculated using heuristic function
	 * plus cost of that node.
	 * 
	 * @return
	 * 
	 */
	public float getHeuristicCostFromGoal();

	/**
	 * @param heuristicCostFromGoal
	 */
	public void setHeuristicCostFromGoal(float heuristicCostFromGoal);

	/**
	 * @return
	 */
	public float getCostFromStart();

	/**
	 * @param costFromStart
	 */
	public void setCostFromStart(float costFromStart);

	/**
	 * @param node
	 * @return
	 */
	public boolean equals(INode node);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(INode otherNode);

	/**
	 * @return
	 */
	public int getCost();

}
