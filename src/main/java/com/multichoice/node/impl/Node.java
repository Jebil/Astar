package com.multichoice.node.impl;

import com.multichoice.enums.NodeType;
import com.multichoice.node.INode;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.impl.XYCoordinate;

/**
 * Implementation of the type Node in two dimension.
 * 
 * @author Jebil Kuruvila
 * 
 */
public class Node implements INode {
	private int cost;
	private NodeType type;
	private XYCoordinate coordinate;

	private INode previousNode;
	private float heuristicCostFromGoal;
	private float costFromStart;

	/**
	 * @param coordinate
	 * @param cost
	 * @param type
	 * 
	 */
	protected Node(XYCoordinate coordinate, int cost, NodeType type) {
		this.coordinate = coordinate;
		this.cost = cost;
		this.type = type;
		this.costFromStart = Integer.MAX_VALUE;
	}

	public NodeType getType() {
		return type;
	}

	public ICoordinate getCoordinates() {
		return coordinate;
	}

	public INode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(INode previousNode) {
		this.previousNode = previousNode;
	}

	public float getHeuristicCostFromGoal() {
		return heuristicCostFromGoal;
	}

	public void setHeuristicCostFromGoal(float heuristicCostFromGoal) {
		this.heuristicCostFromGoal = heuristicCostFromGoal;
	}

	public float getCostFromStart() {
		return costFromStart;
	}

	public void setCostFromStart(float costFromStart) {
		this.costFromStart = costFromStart;
	}

	public boolean equals(INode node) {
		if (this.getCoordinates().equals(node.getCoordinates())) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.multichoice.node.INode#compareTo(com.multichoice.node.INode)
	 */
	public int compareTo(INode otherNode) {
		float thisTotalDistanceFromGoal = heuristicCostFromGoal + costFromStart;
		float otherTotalDistanceFromGoal = otherNode.getHeuristicCostFromGoal() + otherNode.getCostFromStart();

		if (thisTotalDistanceFromGoal < otherTotalDistanceFromGoal) {
			return -1;
		} else if (thisTotalDistanceFromGoal > otherTotalDistanceFromGoal) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getCost() {
		return cost;
	}

}
