package com.newbie.urlshortener.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newbie.urlshortener.repositories.RegisteredUrlRepository;
import com.newbie.urlshortener.exceptions.UrlNotFoundException;
import com.newbie.urlshortener.model.LongUrl;
import com.newbie.urlshortener.model.RegisteredUrl;

/**
 * A Class representing the implementation of the EnlargerService.
 * @author ian.van.nieuwkoop
 *
 */
public class EnlargerServiceImp implements EnlargerService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnlargerServiceImp.class);
	
	@Autowired
	private RegisteredUrlRepository repository;
	
	/**
	 * Default Constructor.
	 */
	public EnlargerServiceImp() {
		LOGGER.debug("Enlarger Service started");
	}

	@Override
	public LongUrl enlargeUrl(String shortUrl) throws MalformedURLException {
		LOGGER.debug("Method enlargeUrl has been called, with value: "+shortUrl);
		URL url = new URL(shortUrl);
		String uniqueIdentifier = getLastBitFromUrl(url.toString());
		return retrieveOriginalUrl(uniqueIdentifier);
	}
	
	@Override
	public LongUrl retrieveOriginalUrl(String uniqueIdentifier) {
		LOGGER.debug("Method retrieveOriginalUrl has been called, with value: "+uniqueIdentifier);
		Optional<RegisteredUrl> registeredUrl_Optional = findRegisteredUrl(uniqueIdentifier);
		RegisteredUrl registeredUrl = registeredUrl_Optional.orElseThrow(() -> new UrlNotFoundException());
		
		return new LongUrl(registeredUrl.getOrignalUrl());
	}
	
	private Optional<RegisteredUrl> findRegisteredUrl(String uniqueIdentifier) {
		List<RegisteredUrl> resiteredUrls = repository.findRegisteredUrlByUrlIdentifier(uniqueIdentifier);
		RegisteredUrl resiteredUrl = null;
		if(!resiteredUrls.isEmpty()) {
			resiteredUrl = resiteredUrls.get(0);
		}
		return Optional.ofNullable(resiteredUrl);
	}
	
	private String getLastBitFromUrl(String url){
	    return url.replaceFirst(".*/([^/?]+).*", "$1");
	}

	
}
