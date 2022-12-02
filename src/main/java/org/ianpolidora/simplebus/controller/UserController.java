package org.ianpolidora.simplebus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.ianpolidora.simplebus.dto.UserCreationDTO;
import org.ianpolidora.simplebus.security.AuthenticatedUserService;
import org.ianpolidora.simplebus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	AuthenticatedUserService aus;

	@GetMapping("/user/signup")
	public ModelAndView showSignUpPage() {
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		log.debug("Successfully showing signup page");

		return response;
	}

	@PostMapping("/user/signup")
	public ModelAndView submitSignUp(@Valid UserCreationDTO userCreationDTO, BindingResult result,
			HttpServletRequest request) {
		ModelAndView response = new ModelAndView();

		response.addObject("form", userCreationDTO);

		if (!result.hasErrors()) {
			userService.signup(userCreationDTO);
			aus.loginNewUser(userCreationDTO, request);

			switch (userCreationDTO.getRole()) {
			case "Parent":
				response.setViewName("redirect:/parent");
				break;
			case "Driver":
				response.setViewName("driver_dashboard");
				break;
			default:
				break;
			}
			log.debug("Successful sign up");
		} else {
			for (ObjectError e : result.getAllErrors()) {
				if (e instanceof FieldError) {
					response.addObject(((FieldError) e).getField() + "Message", e.getDefaultMessage());
				}
			}
		}

		return response;
	}

	@GetMapping("/user/login")
	public ModelAndView showLoginPage() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login");

		return response;
	}
}
