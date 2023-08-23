package org.jsp.merchantproduct.exception;


import org.jsp.merchantproduct.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MerchantException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception){
		ResponseStructure<String>structure = new ResponseStructure<>();
		structure.setData("User Not Found");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentialException exception){
    	ResponseStructure<String>structure = new ResponseStructure<>();
		structure.setData("User Not Found");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }
}
