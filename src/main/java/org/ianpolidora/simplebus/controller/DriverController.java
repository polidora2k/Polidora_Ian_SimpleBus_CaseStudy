package org.ianpolidora.simplebus.controller;

import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.security.AuthenticatedUserService;
import org.ianpolidora.simplebus.service.DriverService;
import org.ianpolidora.simplebus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DriverController {

	@Autowired
	private AuthenticatedUserService aus;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private RouteService routeService;
	
	@GetMapping("/driver")
	public ModelAndView showDriverPage() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("driver_dashboard");

		response.addObject("user", currentUser);
		response.addObject("routes", driverService.getRoutesForDriver(currentUser.getId()));

		return response;
	}
	
	@GetMapping("/driver/route/{id}")
	public ModelAndView showRoutePage(@PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("route");
		
		response.addObject("route", routeService.getRoute(id));
		
		return response;
	}
	
}
