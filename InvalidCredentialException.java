package org.jsp.merchantproduct.exception;

public class InvalidCredentialException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid Phone and Password";
	}
	
	

}
