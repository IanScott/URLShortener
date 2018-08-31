package com.newbie.urlshortener.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newbie.urlshortener.generator.UrlIdentifierGenerator;
import com.newbie.urlshortener.model.RegisteredUrl;
import com.newbie.urlshortener.model.ShortUrl;
import com.newbie.urlshortener.repositories.RegisteredUrlRepository;

/**
 * This Class represents the Implementation of the ShortenerService.
 * @author ian.van.nieuwkoop
 * @version 0.1
 *
 */
public class ShortenerServiceImp implements ShortenerService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShortenerServiceImp.class);
	
	@Autowired
	private URL baseUrl;

	@Autowired
	private UrlIdentifierGenerator urlIdentifierGenerator;
	
	@Autowired
	private RegisteredUrlRepository repository;
	
	/**
	 * Default Constructor.
	 */
	public ShortenerServiceImp() {
		LOGGER.debug("Shortener Service started");
	}
	
	@Override
	public ShortUrl shortenUrl(String longUrl) throws MalformedURLException {
		LOGGER.debug("shortenUrl being called with value: "+longUrl);
		URL url = new URL(longUrl);
		Optional<RegisteredUrl> registeredUrl_Optional = findRegisteredUrl(url.toString());
		RegisteredUrl registeredUrl = registeredUrl_Optional.orElseGet(
				()->{return createAndSaveRegisteredUrl(longUrl);});
		
		return new ShortUrl(baseUrl+registeredUrl.getUrlIdentifier());
    }
	
	private RegisteredUrl createAndSaveRegisteredUrl(String longUrl) {
		String uid = urlIdentifierGenerator.generate();
		RegisteredUrl registeredUrl = new RegisteredUrl(uid,longUrl);
		
		repository.save(registeredUrl);
		return registeredUrl;
	}
	
	private Optional<RegisteredUrl> findRegisteredUrl(String longUrl) {
		List<RegisteredUrl> resiteredUrls = repository.findRegisteredUrlByOrignalUrl(longUrl);
		RegisteredUrl resiteredUrl = null;
		if(!resiteredUrls.isEmpty()) {
			resiteredUrl = resiteredUrls.get(0);
		}
		return Optional.ofNullable(resiteredUrl);
	}
	
}
