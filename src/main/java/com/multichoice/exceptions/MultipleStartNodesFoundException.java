package com.multichoice.exceptions;

/**
 * @author Jebil Kuruvila
 *
 */
public class MultipleStartNodesFoundException extends NodeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5646336136918578371L;

	public MultipleStartNodesFoundException() {
		super("ERROR: More than one start node found");
	}

	public MultipleStartNodesFoundException(String message) {
		super(message);
	}

	public MultipleStartNodesFoundException(Throwable cause) {
		super(cause);
	}

	public MultipleStartNodesFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
