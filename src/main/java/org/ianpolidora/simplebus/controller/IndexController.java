package org.ianpolidora.simplebus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash() {
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		log.debug("Successfully showing page");
		
		return response;
	}
}
