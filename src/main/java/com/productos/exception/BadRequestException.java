package com.productos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//excepciones
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	 public BadRequestException(String mensaje) {
	        super(mensaje);
	    }
}
