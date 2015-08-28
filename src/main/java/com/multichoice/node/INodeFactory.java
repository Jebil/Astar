package com.multichoice.node;

public interface INodeFactory {
	public INode newStartNode(int... coordinates);

	public INode newNode(int... coordinates);

	public INode newObstacleNode(int... coordinates);

	public INode newGoalNode(int... coordinates);

	public INode newOtherNode(int cost, int... coordinates);
}
