package com.newbie.urlshortener.services;

import java.net.MalformedURLException;
import org.springframework.stereotype.Service;
import com.newbie.urlshortener.model.ShortUrl;

/**
 * An Interface representing a Service to Shorten a URL.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@Service
public interface ShortenerService {
	/**
	 * @param longUrl a string representing the URL to Shorten.
	 * @return a ShortUrl object.
	 * @throws MalformedURLException if longUrl is not a well formed URL.
	 */
	public abstract ShortUrl shortenUrl(String longUrl) throws MalformedURLException;
}
