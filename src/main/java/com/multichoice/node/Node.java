package com.multichoice.node;

import java.util.ArrayList;

import com.multichoice.enums.NodeType;
import com.multichoice.node.coordinate.ICoordinate;
import com.multichoice.node.coordinate.XYCoordinate;

public class Node implements INode {
	private Node north;
	private Node northEast;
	private Node east;
	private Node southEast;
	private Node south;
	private Node southWest;
	private Node west;
	private Node northWest;
	private int cost;
	private NodeType type;
	private XYCoordinate coordinate;
	private ArrayList<INode> neighbourList;
	private boolean isVisited;
	private INode previousNode;
	private float heuristicCostFromGoal;
	private float costFromStart;

	protected Node() {

	}

	public Node getWest() {
		return west;
	}

	public void setWest(Node west) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.west))
			neighbourList.remove(this.west);
		neighbourList.add(west);
		this.west = west;
	}

	public void setNorth(Node north) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.north))
			neighbourList.remove(this.north);
		neighbourList.add(north);
		this.north = north;
	}

	public void setNorthEast(Node northEast) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.northEast))
			neighbourList.remove(this.northEast);
		neighbourList.add(northEast);
		this.northEast = northEast;
	}

	public void setEast(Node east) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.east))
			neighbourList.remove(this.east);
		neighbourList.add(east);
		this.east = east;
	}

	public void setSouthEast(Node southEast) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.southEast))
			neighbourList.remove(this.southEast);
		neighbourList.add(southEast);
		this.southEast = southEast;
	}

	public void setSouth(Node south) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.south))
			neighbourList.remove(this.south);
		neighbourList.add(south);
		this.south = south;
	}

	public void setSouthWest(Node southWest) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.southWest))
			neighbourList.remove(this.southWest);
		neighbourList.add(southWest);
		this.southWest = southWest;
	}

	public void setNorthWest(Node northWest) {
		// replace the old Node with the new one in the neighborList
		if (neighbourList.contains(this.northWest))
			neighbourList.remove(this.northWest);
		neighbourList.add(northWest);
		this.northWest = northWest;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public ICoordinate getCoordinates() {
		return coordinate;
	}

	public void setCoordinate(ICoordinate coordinate) {
		this.coordinate = (XYCoordinate) coordinate;
	}

	public ArrayList<INode> getNeighborList() {
		return neighbourList;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		this.isVisited = visited;
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

	public void setCost(int cost) {
		this.cost = cost;
	}

}
