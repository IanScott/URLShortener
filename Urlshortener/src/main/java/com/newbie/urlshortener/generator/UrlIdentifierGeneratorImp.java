package com.newbie.urlshortener.generator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.newbie.urlshortener.model.Counter;
import com.newbie.urlshortener.repositories.CounterRepository;
import com.newbie.urlshortener.util.Base62;

/**
 * Class used to generate unique id.
 * @author ian.van.nieuwkoop
 *
 */
public class UrlIdentifierGeneratorImp implements UrlIdentifierGenerator{
	
	@Autowired
	private CounterRepository repository;
	private Counter counter;
	
	@Override
	public String generate() {
		if(counter == null) {
			Optional<Counter> optional = repository.findById(1L);
			counter = optional.orElseGet(()->new Counter());
			
		}
        final int counterValue =  (counter.retrieveAndIncrement()) % 1000;
        repository.save(counter);
        final long base10Id = Long.valueOf("" + counterValue + System.currentTimeMillis());
        return Base62.fromBase10(base10Id);
	}

	
}
