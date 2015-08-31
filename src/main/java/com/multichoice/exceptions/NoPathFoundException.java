package com.multichoice.exceptions;

public class NoPathFoundException extends NodeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2154159317451418153L;

	public NoPathFoundException() {
		super("Path to goal could not be found.");
	}

	public NoPathFoundException(String string) {
		super(string);
	}

	public NoPathFoundException(Throwable cause) {
		super(cause);
	}

	public NoPathFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
