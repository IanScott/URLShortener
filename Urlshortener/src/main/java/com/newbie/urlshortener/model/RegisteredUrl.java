package com.newbie.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A POJO and Entity which represents the unique identifier of the Shortened URL and its meta data to be persisted.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@Entity
public class RegisteredUrl {
	@Id @GeneratedValue 
	private Long id;
	private String urlIdentifier;
	private String orignalUrl;
	
	/**
	 * Default Constructor
	 */
	public RegisteredUrl() {}
	
	/**
	 * Construtor with two parameters.
	 * @param urlIdentifier The unique identifier
	 * @param originalUrl The original Long url.
	 */
	public RegisteredUrl(String urlIdentifier, String originalUrl) {
		this.urlIdentifier = urlIdentifier;
		this.orignalUrl = originalUrl;
	}
	
	/**
	 * Returns id
	 * @return id in form of Long.
	 */
	public Long getId() {
		 return this.id;
	}
	
	/**
	 * Simple setter.
	 * @param id long to set id.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 *  Returns unique url identifier.
	 * @return String of identifier
	 */
	public String getUrlIdentifier() {
		return urlIdentifier;
	}
	
	/**
	 * Method used to set url unique identifier.
	 * @param urlIdentifier
	 */
	public void setUrlIdentifier(String urlIdentifier) {
		this.urlIdentifier = urlIdentifier;
	}
	
	/**
	 * Method used to retrieve original Url. 
	 * @return String representation of original URL.
	 */
	public String getOrignalUrl() {
		return orignalUrl;
	}
	
	/**
	 * Setter to set original url.
	 * @param orignalUrl a String representation of the original URL.
	 */
	public void setOrignalUrl(String orignalUrl) {
		this.orignalUrl = orignalUrl;
	}

}
