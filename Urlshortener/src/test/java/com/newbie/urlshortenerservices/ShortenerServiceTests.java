package com.newbie.urlshortenerservices;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newbie.urlshortener.UrlshortenerApplication;
import com.newbie.urlshortener.model.ShortUrl;
import com.newbie.urlshortener.services.ShortenerService;

@SpringBootTest(classes = UrlshortenerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ShortenerServiceTests {

    @Autowired
    private ShortenerService shortenerService;
    
	
	@Test
    public void should_createNewShortenedUrl_when_postedUrlDoesNotExist() throws MalformedURLException {
        // Given
        String longUrl = "http://www.nu.nl";
        ShortUrl shorturl = shortenerService.shortenUrl(longUrl);
        
        assertThat(shorturl).isNotNull();
        assertThat(shorturl.getShortUrl()).isNotNull();
    }
	
	@Test(expected = MalformedURLException.class)
    public void expecting_InvalidUrlException() throws MalformedURLException {
        // Given
        String longUrl = "error";
        shortenerService.shortenUrl(longUrl);
    }
	
}
