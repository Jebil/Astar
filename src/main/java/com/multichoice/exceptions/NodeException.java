package com.multichoice.exceptions;

public class NodeException extends Exception {
	/**
	 * Base class for all node exceptions.
	 */
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
