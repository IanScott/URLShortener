package com.newbie.urlshortenerservices;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newbie.urlshortener.model.LongUrl;
import com.newbie.urlshortener.model.ShortUrl;
import com.newbie.urlshortener.services.EnlargerService;
import com.newbie.urlshortener.services.ShortenerService;
import com.newbie.urlshortener.UrlshortenerApplication;
import com.newbie.urlshortener.exceptions.UrlNotFoundException;


@SpringBootTest(classes = UrlshortenerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EnlargerServiceTest {
	
	@Autowired
	private EnlargerService enlargerService;
	
	@Autowired
    private ShortenerService shortenerService;
	
	@Test
	 public void should_reuseExistingShortenedUrl_when_postedUrlExists() throws IOException {
	     ShortUrl shorturl = shortenerService.shortenUrl("http://www.test123.nl");
	 	
	     LongUrl longurl = enlargerService.enlargeUrl(shorturl.getShortUrl());
	     
	     assertThat(longurl.getLongUrl()).isEqualTo("http://www.test123.nl");
	  
	 }
	 
	 @Test(expected = MalformedURLException.class)
	 public void expecting_MalformedURlException() throws MalformedURLException {
		 String shortUrl = "error";
		 enlargerService.enlargeUrl(shortUrl);
	 }
	 
	 @Test(expected = UrlNotFoundException.class)
	 public void expecting_UrlNotFoundException() throws MalformedURLException {
		 String shortUrl = "http://www.error.com";
		 enlargerService.enlargeUrl(shortUrl);
	 }
	   
}
