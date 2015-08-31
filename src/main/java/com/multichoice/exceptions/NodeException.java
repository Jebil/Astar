package com.multichoice.exceptions;

/**
 * Base class for all node exceptions.
 * 
 * @author Jebil Kuruvila
 *
 */
public class NodeException extends Exception {
	public NodeException(String string) {
		super(string);
	}

	public NodeException(Throwable cause) {
		super(cause);
	}

	public NodeException(String messages, Throwable cause) {
		super(messages, cause);
	}

	private static final long serialVersionUID = 6712302071238690291L;

}
