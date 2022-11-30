package org.ianpolidora.simplebus.controller;

import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SignUpController {

	@Autowired
	UserService userService;
	
	@GetMapping("/signup")
	public ModelAndView showSignUpPage() {
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		log.debug("Successfully showing signup page");
		
		return response;
	}
	
	@PostMapping("/signup")
	public ModelAndView submit( @ModelAttribute("user") UserDTO userDTO) {
		ModelAndView response = new ModelAndView();
		
		if (userService.signup(userDTO)) {
			response.setViewName("signup");
			log.debug("Successfully signed up");
		}
		
		return response;
	}
}
