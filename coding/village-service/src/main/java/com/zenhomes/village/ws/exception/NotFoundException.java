package com.zenhomes.village.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author LoganPhan
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public NotFoundException(String message) {
    	
        super(message);
    }
}