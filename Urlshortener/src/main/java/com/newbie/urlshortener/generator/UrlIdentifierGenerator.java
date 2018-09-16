package com.newbie.urlshortener.generator;


/**
 * Interface containing a method to generate a unique identifier.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
public interface UrlIdentifierGenerator {
	
	/**
	 * Method which returns an unique identifier
	 * @return a String representation of an unique identifier.
	 */
    public abstract String generate();

}
