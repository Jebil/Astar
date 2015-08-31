package com.multichoice.exceptions;

/**
 * @author Jebil Kuruvila
 *
 */
public class MultipleGoalNodesFoundException extends NodeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5072292477149541059L;

	public MultipleGoalNodesFoundException() {
		super("ERROR: More than one goal node found");
	}

	public MultipleGoalNodesFoundException(String messages) {
		super(messages);
	}

	public MultipleGoalNodesFoundException(Throwable cause) {
		super(cause);
	}

	public MultipleGoalNodesFoundException(String messages, Throwable cause) {
		super(messages, cause);
	}

}
