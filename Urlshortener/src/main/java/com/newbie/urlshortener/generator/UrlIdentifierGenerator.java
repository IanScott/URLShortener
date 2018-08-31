package com.newbie.urlshortener.generator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Interface containing a method to generate a unique identifier.
 * @author ian.van.nieuwkoop
 * @version 0.1
 */
@FunctionalInterface
public interface UrlIdentifierGenerator {
	
	//Global variable
	public static AtomicInteger counter = new AtomicInteger();
	/**
	 * Method which returns an unique identifier
	 * @return a String representation of an unique identifier.
	 */
    public abstract String generate();

}
