package com.newbie.urlshortener.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.newbie.urlshortener.model.RegisteredUrl;

/**
 * Interface used to access the repository.
 * @author ian.van.nieuwkoop
 * @version 0.1
 * This will be AUTO IMPLEMENTED by Spring into a Bean called RegisteredUrlRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface RegisteredUrlRepository extends CrudRepository<RegisteredUrl, Long> {
	
	/**
	 * Method used to find RegisteredUrl Entities by the property OriginalUrl.
	 * @param orignalUrl the value of the property to search by.
	 * @return a list of RegisteredUrls containing the orginalUrl.
	 */
	public abstract List<RegisteredUrl> findRegisteredUrlByOrignalUrl(String orignalUrl);
	
	/**
	 * Method used to find RegisteredUrl Entities by the property UrlIdentifier.
	 * @param urlIdentifier the value of the property to search by.
	 * @return a list of RegisteredUrls containing the orginalUrl.
	 */
	public abstract List<RegisteredUrl> findRegisteredUrlByUrlIdentifier(String urlIdentifier);
}