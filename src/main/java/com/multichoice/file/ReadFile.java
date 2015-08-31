package com.multichoice.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Jebil Kuruvila
 *
 *         Wrapper for all the file operations.
 */
public class ReadFile {
	/**
	 * Get the file path of our executable jar file. During development it will
	 * be the target folder.
	 */
	static File jarPath = new File(ReadFile.class.getProtectionDomain().getCodeSource().getLocation().getPath());

	/**
	 * Extract the path as String
	 */
	static String filePath = jarPath.getParentFile().getAbsolutePath();

	/**
	 * Temporary String for reading from file.
	 */
	String temp;
	/**
	 * Default file name for input file.
	 */
	String fileInName = "/map.txt";
	/**
	 * Default file name for output file.
	 */
	static String fileOutName = "/map-out.txt";

	/**
	 * @return
	 * @throws IOException
	 *             Used to read the file from the jar folder and convert it into
	 *             a two dimensional array format for better accessing as x,y
	 *             coordinates.
	 */
	public char[][] getFileAsCharArray() throws IOException {
		File f = new File(filePath + File.separator + fileInName);
		return getFileAsCharArray(f);
	}

	public char[][] getFileAsCharArray(File f) throws IOException {
//		fileOutName = f.getName(). + "-out";
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
		File file = new File(filePath + File.separator + fileOutName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fw;
	}

	public static File getOutputFile(){
		return  new File(filePath + File.separator + fileOutName);
	}

}
