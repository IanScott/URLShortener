package com.newbie.urlshortener.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * Class representing an Invalid URL Runtime Exception.
 * @author ian.van.nieuwkoop
 *
 */
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Unable to process input.")
public class InvalidUrlException extends RuntimeException {
	private static final long serialVersionUID = 3124581897536324348L;
}
