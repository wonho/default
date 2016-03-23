package edu.showcase.system.exception;

public class DaoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable T) {
		super(message,T);
	}
}

