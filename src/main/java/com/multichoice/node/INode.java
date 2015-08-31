package com.multichoice.node;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.ICoordinate;

/**
 * @author Jebil Kuruvila
 *
 */
public interface INode extends Comparable<INode> {
	/**
	 * @return
	 */
	public NodeType getType();

	// public void setType(NodeType type);

	/**
	 * @return
	 */
	public ICoordinate getCoordinates();

	// public void setCoordinate(ICoordinate coordinate);

	// public ArrayList<INode> getNeighborList();

	// public boolean isVisited();

	// public void setVisited(boolean visited);

	/**
	 * @return
	 */
	public INode getPreviousNode();

	/**
	 * @param previousNode
	 */
	public void setPreviousNode(INode previousNode);

	/**
	 * @return
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

	// public void setCost(int cost);
}
