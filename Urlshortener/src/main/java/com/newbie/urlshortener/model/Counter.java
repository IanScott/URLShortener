package com.newbie.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class representing a Counter, used by the UrlIdentifierGenerator.
 * @author ian.van.nieuwkoop
 *
 */
@Entity
public class Counter {
	@Id 
	private Long id = 1L;
	private int value = 0;
	
	/**
	 * Default Counstructor
	 */
	public Counter() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public synchronized int retrieveAndIncrement() {
		return ++value;
	}
	
}
