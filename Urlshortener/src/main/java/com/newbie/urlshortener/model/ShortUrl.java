package com.newbie.urlshortener.model;

/**
 * POJO representing a Shortened Url.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
public class ShortUrl {
	
	private String shortUrl;
	
	/**
	 * Default Constructor.
	 */
	public ShortUrl() {}
	
	/**
	 * Constructor with one parameter.
	 * @param shortUrl a String representing the Shortened URL.
	 */
	public ShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	/**
	 * Method to get String representation of shortened URL.
	 * @return String representation of shortened URL.
	 */
	public String getShortUrl() {
		return this.shortUrl;	
	}
	
	/**
	 * Method to set shortURL.
	 * @param shortUrl the String to set.
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
