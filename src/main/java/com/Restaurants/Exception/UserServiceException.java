package com.Restaurants.Exception;

public class UserServiceException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public UserServiceException() {
        super();
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceException(Throwable cause) {
        super(cause);
    }

}
