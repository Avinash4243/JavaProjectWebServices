package org.citiustech.RESTfulAPI.messenger.Exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 935516443487191567L;
	public DataNotFoundException(String message) {
		super(message);
		System.out.println(message);
		
	}

}
