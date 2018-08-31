package com.newbie.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class representing the Application.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@SpringBootApplication
public class UrlshortenerApplication {
	
	/**
	 * The main method to start the application.
	 * @param args 
	 */
	public static void main(String[] args) {
		SpringApplication.run(UrlshortenerApplication.class, args);
	}
}
