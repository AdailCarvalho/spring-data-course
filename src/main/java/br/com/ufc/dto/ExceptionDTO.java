/**
 * 
 */
package br.com.ufc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Adail Carvalho
 *
 * @version 
 *
 * @since 18/05/2016 
 */
public class ExceptionDTO {
	
	@JsonProperty(value = "codigo")
	private String code;
	
	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "excecao")
	private String exception;
	
	public ExceptionDTO(String code) {
		super();
		this.code = code;
	}
	
	public ExceptionDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ExceptionDTO(String code, String message, Exception exception) {
		super();
		this.code = code;
		this.message = message;
		this.exception = exception.toString();
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getException() {
		return exception;
	}
}