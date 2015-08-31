package com.multichoice.constants;

/**
 * Holder of all constant values.
 * 
 * @author Jebil Kuruvila
 *
 */
public class Constants {
	public static final char START_NODE = '@';
	public static final char GOAL_NODE = 'X';
	public static final char OBSTACLE_NODE = '~';
	public static final char FOREST_NODE = '*';
	public static final char FLATLAND_NODE = '.';
	public static final char MOUNTAIN_NODE = '^';
	public static final int COST_FLATLAND = 1;
	public static final int COST_FOREST = 2;
	public static final int COST_MOUNTAIN = 3;
	public static final char PATH_SYMBOL = '#';
	public static final String ASTAR_ALGORITHM = "astar";
	public static final String MANHATTAN_HEURISTIC = "manhattan";
	public static final String FILE_INPUT_OPTION = "-f";
	public static final String ALLOW_DIAGONAL_FLAG = "-d";
}
