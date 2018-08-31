package com.newbie.urlshortener.services;

import java.net.MalformedURLException;

import org.springframework.stereotype.Service;
import com.newbie.urlshortener.model.LongUrl;

/**
 * An Interface representing a Service to retrieve shortened URLs.
 * @author ian.van.nieuwkoop
 *
 */
@Service
public interface EnlargerService {
	/**
	 * The Method for retrieving the original URL of a shortened URL.
	 * @param shortUrl the shortened URL who's original URL to find.
	 * @return An LongUrl object representing the original long URL.
	 * @throws MalformedURLException if shortrl is not a valid URL.
	 */
	public abstract LongUrl enlargeUrl(String shortUrl)throws MalformedURLException;
	
	/**
	 * Method for retrieving an orginal long url using the uniqueIdentifier.
	 * @param uniqueIdentifier the unique id of the url to find.
	 * @return an LongUrl object
	 */
	public abstract LongUrl retrieveOriginalUrl(String uniqueIdentifier);
}
