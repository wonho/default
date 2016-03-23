package edu.showcase.system.exception;

public class DefaultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public DefaultException(String message) {
			super(message);
	}
		
	public DefaultException(String message, Throwable t) {
			super(message, t);
	}


}
