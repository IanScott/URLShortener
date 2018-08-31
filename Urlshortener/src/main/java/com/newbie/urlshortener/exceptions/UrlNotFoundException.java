package com.newbie.urlshortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class representing an URL Not Found URL Runtime Exception.
 * @author ian.van.nieuwkoop
 *
 */
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cannot find the URL.")
public class UrlNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3124581897536324348L;
}
