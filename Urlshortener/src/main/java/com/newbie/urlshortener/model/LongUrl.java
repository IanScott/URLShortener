package com.newbie.urlshortener.model;

/**
 * POJO representing a long/ original Url before shortening.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
public class LongUrl {
	private String longUrl;
	
	/**
	 * Default contructor
	 */
	public LongUrl() {}
	
	/**
	 * Constructor with one parameter
	 * @param longUrl. A String representing the URL to shorten.
	 */
	public LongUrl(String longUrl) {
		 this.longUrl = longUrl;
	 }
	 
	/**
	 * Simple Getter.
	 * @return The original URL.
	 */
	 public String getLongUrl() {
		 return this.longUrl;	
	 }
	 
	 /**
	  * Default setter.
	  * @param originalUrl a String representing the original long url.
	  */
	public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
	}
}
