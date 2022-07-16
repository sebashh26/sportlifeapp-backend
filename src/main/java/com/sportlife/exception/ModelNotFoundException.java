package com.sportlife.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class ModelNotFoundException extends Exception{
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String msg) {
		super(msg);
	}
	

}
