package com.multichoice.node;

import java.util.ArrayList;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.ICoordinate;

public interface INode extends Comparable<INode> {
	public NodeType getType();

	public void setType();

	public ICoordinate getCoordinates();

	public void setCoordinate(ICoordinate coordinate);

	public ArrayList<INode> getNeighborList();

	public boolean isVisited();

	public void setVisited(boolean visited);

	public INode getPreviousNode();

	public void setPreviousNode(INode previousNode);

	public float getHeuristicCostFromGoal();

	public void setHeuristicCostFromGoal(float heuristicCostFromGoal);

	public float getCostFromStart();

	public void setCostFromStart(float costFronStart);

	public boolean equals(INode node);

	public int compareTo(INode otherNode);
}
