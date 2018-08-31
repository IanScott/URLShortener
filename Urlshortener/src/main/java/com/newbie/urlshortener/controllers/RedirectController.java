package com.newbie.urlshortener.controllers;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.newbie.urlshortener.model.LongUrl;
import com.newbie.urlshortener.services.EnlargerService;

/**
 * This is the Controller for redirecting shortened URLs to the original.
 * Controller has 1 entry point.
 * @author ian.van.nieuwkoop
 *
 */
@RestController
public class RedirectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RedirectController.class);
	private final EnlargerService enlargerService;
	
	/**
	 * Main Constructor, parameters are added using Autowiring.
	 * @param enlargerService
	 */
	@Autowired
	public RedirectController(EnlargerService enlargerService) {
		this.enlargerService = enlargerService;
	}
	@GetMapping("/{uid}")
	public ModelAndView redirect(HttpServletResponse httpServletResponse,@PathVariable("uid") String uid) {
		LOGGER.debug("redirect method called");
		LongUrl longurl = enlargerService.retrieveOriginalUrl(uid);
		return new ModelAndView("redirect:" + longurl.getLongUrl());
    }
	
}
