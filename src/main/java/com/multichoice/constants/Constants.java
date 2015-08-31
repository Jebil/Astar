package com.multichoice.constants;

/**
 * Holder of all constant values.
 * 
 * @author Jebil Kuruvila
 *
 */
public class Constants {
	public static final char startNode = '@';
	public static final char goalNode = 'X';
	public static final char obstacleNode = '~';
	public static final char forestNode = '*';
	public static final char flatLand = '.';
	public static final char mountain = '^';
	public static int costFlatland = 1;
	public static int costForest = 2;
	public static int costMountain = 3;
	public static final char pathSymbol = '#';
	public static String AstarAlgorithm = "astar";
	public static String ManhattanHeuristic = "manhattan";
}
