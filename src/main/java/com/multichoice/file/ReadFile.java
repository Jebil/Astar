package com.multichoice.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @author Jebil Kuruvila
 *
 *         Wrapper for all the file operations.
 */
public class ReadFile {
	private static Logger logger = Logger.getLogger(ReadFile.class);
	/**
	 * Get the file path of our executable jar file. During development it will
	 * be the target folder.
	 */
	private static File jarPath = new File(
			ReadFile.class.getProtectionDomain().getCodeSource().getLocation().getPath());

	/**
	 * Extract the path as String
	 */
	private static String filePath = jarPath.getParentFile().getAbsolutePath();

	/**
	 * Temporary String for reading from file.
	 */
	private static String temp;
	/**
	 * Default file name for input file.
	 */
	private static String fileInName = "/map.txt";
	/**
	 * Default file name for output file.
	 */
	private static String fileOutName = "/map-out.txt";

	/**
	 * @return
	 * @throws IOException
	 *             Used to read the file from the jar folder and convert it into
	 *             a two dimensional array format for better accessing as x,y
	 *             coordinates.
	 */
	// public static char[][] getFileAsCharArray() throws IOException {
	//
	// return getFileAsCharArray(filePath + fileInName);
	// }

	public static char[][] getFileAsCharArray(String file) throws IOException {
		File f;
		if (null != file) {
			f = new File(file);
			logger.debug("Trying to read given file " + f.getName());
		} else {
			logger.debug("No file specified in command line arguments, trying default file name map.txt");
			f = new File(filePath + fileInName);
		}
		int pos = f.getName().lastIndexOf(".");
		if (pos > 0) {
			fileOutName = f.getName().substring(0, pos) + "-out.txt";
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		// ArrayList to temporarily store the data.
		ArrayList<char[]> list = new ArrayList<char[]>();
		while (br.ready()) {
			temp = br.readLine();
			// To eliminate blank lines.
			if (!(temp.trim().equals(""))) {
				list.add(temp.toCharArray());
			}
		}
		// Two dimensional character array to plot as x,y coordinates.
		char[][] charSet = new char[list.size()][];

		// Convert ArrayList to character array.
		for (int i = 0; i < list.size(); i++) {
			charSet[i] = list.get(i);
		}
		// Make the ArrayList ready for garbage collection.
		list = null;
		fr.close();
		br.close();
		return charSet;
	}

	/**
	 * @return
	 * 
	 * 		Method to return the output file writer. output file name will be
	 *         map-out.txt. It will be in the same folder. During development it
	 *         will be in the target folder.
	 */
	public static FileWriter getFileWriter() {
		return getFileWriter(fileOutName);
	}

	public static FileWriter getFileWriter(String fileOutName) {
		File file = new File(filePath + "/out" + File.separator + fileOutName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		logger.debug("Writing to file out/" + file.getName());
		return fw;
	}

	// public static File getOutputFile() {
	// return new File(filePath + File.separator + fileOutName);
	// }

}
