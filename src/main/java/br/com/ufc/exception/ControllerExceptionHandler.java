/**
 * 
 */
package br.com.ufc.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ufc.dto.ExceptionDTO;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */

@ControllerAdvice
@Configuration
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<Object> constraintValidationException(ConstraintViolationException ex, WebRequest request) {
		List<ExceptionDTO> response = new ArrayList<ExceptionDTO>();
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		for (ConstraintViolation<?> constraintEx : ex.getConstraintViolations()) {
			response.add(new ExceptionDTO(constraintEx.getMessageTemplate().replaceAll("[{}]", ""), constraintEx.getMessage()));
		}
		
		return handleExceptionInternal(ex, response, headers, status, request);
	}
}