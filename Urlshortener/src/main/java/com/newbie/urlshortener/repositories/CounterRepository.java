package com.newbie.urlshortener.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newbie.urlshortener.model.Counter;

/**
 * Interface used to access the repository.
 * @author ian.van.nieuwkoop
 * @version 0.1
 * This will be AUTO IMPLEMENTED by Spring into a Bean called RegisteredUrlRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface CounterRepository extends CrudRepository<Counter, Long> {

}