package org.ianpolidora.simplebus.controller;

import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ParentController {
	
	@Autowired
	AuthenticatedUserService aus;
	
	@GetMapping("/parent")
	public ModelAndView showParentPage() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("parent_dashboard");
		
		response.addObject("user", currentUser);
		
		return response;
	}
}
