package org.ianpolidora.simplebus.exception;

public class IncorrectPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException() {
	}

	public IncorrectPasswordException(String message) {
		super(message);
	}

}
