package com.newbie.urlshortener;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.newbie.urlshortener.util.Base62;
import com.newbie.urlshortener.generator.UrlIdentifierGenerator;
import com.newbie.urlshortener.generator.UrlIdentifierGeneratorImp;
import com.newbie.urlshortener.services.EnlargerService;
import com.newbie.urlshortener.services.EnlargerServiceImp;
import com.newbie.urlshortener.services.ShortenerService;
import com.newbie.urlshortener.services.ShortenerServiceImp;

/**
 * Class representing the Application Configuration. 
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

	 @Value("${baseUrl}")
	 private String baseUrl;
	 
	 @Bean
	 public URL baseUrl() throws MalformedURLException {
		 return new URL(baseUrl);
	 }
	 @Bean
	 public UrlIdentifierGenerator urlIdentifierGenerator() {
		 return new UrlIdentifierGeneratorImp();
	 }
	
	 @Bean
	 @Primary
	 public ShortenerService shortenerService() {
		 return new ShortenerServiceImp();
	 }
	 
	 @Bean
	 @Primary
	 public EnlargerService enlargerService() {
		 return new EnlargerServiceImp();
	 }
}
