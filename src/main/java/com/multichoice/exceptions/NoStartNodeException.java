package com.multichoice.exceptions;

/**
 * @author Jebil Kuruvila
 *
 */
public class NoStartNodeException extends NodeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 747223154776075032L;

	public NoStartNodeException() {
		super("ERROR: No start node found.");
	}

	public NoStartNodeException(String message) {
		super(message);
	}

	public NoStartNodeException(Throwable cause) {
		super(cause);
	}

	public NoStartNodeException(String message, Throwable cause) {
		super(message, cause);
	}
}
