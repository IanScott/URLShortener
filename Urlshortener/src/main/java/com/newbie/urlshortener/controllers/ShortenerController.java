package com.newbie.urlshortener.controllers;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newbie.urlshortener.exceptions.InvalidUrlException;
import com.newbie.urlshortener.model.LongUrl;
import com.newbie.urlshortener.model.ShortUrl;
import com.newbie.urlshortener.services.EnlargerService;
import com.newbie.urlshortener.services.ShortenerService;
/** 
 * This class represents the main Controller for this application. 
 * It has two EntryPoints: 
 * shorten which takes a JSON object in the form of {"longUrl": <Url to shorten>}
 * and return JSON containing a shortened Url {"shortenedUrl": "<shortend Url>"}
 * 
 * And enlarge which takes a SON object in the form of {"longUrl": <Url to shorten>}
 * and return JSON containing the orginal Url {"LongUrl": "<shortend Url>"} 
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@RestController
@RequestMapping("/shortener")
public class ShortenerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShortenerController.class);
	private final ShortenerService shortenerService;
	private final EnlargerService enlargerService;
	
	/**
	 * Main Constructor, parameters are added using Autowiring.
	 * @param shortenerService
	 * @param enlargerService
	 */
	@Autowired
	public ShortenerController(ShortenerService shortenerService, EnlargerService enlargerService) {
		this.shortenerService = shortenerService;
		this.enlargerService = enlargerService;
	}
	
	/**
	 * Method to shorten a URL.
	 * @param longUrl a String representing the URL to shorten.
	 * @return an Object representing to Shortened Url.
	 */
	@PostMapping("/shorten")
	public ShortUrl shortenUrl(@RequestBody LongUrl longUrl) {
		LOGGER.debug("shortenUrl being called");
		try {
			return shortenerService.shortenUrl(longUrl.getLongUrl());
		} catch (MalformedURLException e) {
			LOGGER.debug("InvalidUrlException being thrown");
			throw new InvalidUrlException();
		}
	}
	
	/**
	 * A method to convert a shortened URL back to its original long form.
	 * @param shortUrl the URL to convert back.
	 * @return an Object representing the Original Long Url.
	 */
	@PostMapping("/enlarge")
	public LongUrl expandUrl(@RequestBody ShortUrl shortUrl) {
		LOGGER.debug("expandUrl being called");
		try {
			return enlargerService.enlargeUrl(shortUrl.getShortUrl());
		} catch (MalformedURLException e) {
			LOGGER.debug("InvalidUrlException being thrown");
			throw new InvalidUrlException();
		}
	} 
}

