package com.eduard.controller;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlingController {

	@ExceptionHandler({ PersistenceException.class })
	public ModelAndView handleException(PersistenceException ex) {
		// Do something additional if required
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("databaseError");
		modelAndView.addObject("message", ex.getMessage());
		return modelAndView;
	}

}
