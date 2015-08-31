package com.multichoice.exceptions;

/**
 * @author Jebil Kuruvila
 *
 */
public class NoGoalNodeException extends NodeException {

	private static final long serialVersionUID = -8318014721585175292L;

	public NoGoalNodeException() {
		super("ERROR: No goal node found.");
	}

	public NoGoalNodeException(String message) {
		super(message);
	}

	public NoGoalNodeException(Throwable cause) {
		super(cause);
	}

	public NoGoalNodeException(String message, Throwable cause) {
		super(message, cause);
	}
}
