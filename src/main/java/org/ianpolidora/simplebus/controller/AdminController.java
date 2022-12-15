package org.ianpolidora.simplebus.controller;

import javax.validation.Valid;

import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.dto.StopCreationDTO;
import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.security.AuthenticatedUserService;
import org.ianpolidora.simplebus.service.RouteService;
import org.ianpolidora.simplebus.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
	@Autowired
	private AuthenticatedUserService aus;
	
	@Autowired
	private StopService stopService;
	
	@Autowired
	private RouteService routeService;
	
	@GetMapping("/admin")
	public ModelAndView showAdminPage() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("admin_dashboard");

		response.addObject("user", currentUser);

		return response;
	}
	
	@GetMapping("/admin/addroute")
	public ModelAndView showAddRoutePage() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("add_route");
		
		response.addObject("unassignedStops", stopService.getUnassignedStops());

		return response;
	}
	
	@PostMapping("/admin/addroute")
	public ModelAndView addRoute(@RequestParam String routeName) {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		
		RouteDTO route = routeService.addRoute(routeName);
		
		response.setViewName("redirect:/admin/addroute/" + route.getId() + "/addstops");
		

		return response;
	}
	
	@GetMapping("/admin/addroute/{id}/addstops")
	public ModelAndView showAddRouteStopsPage(@PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("add_stop");
		response.addObject("routeId", id);
		
		return response;
	}
	
	@PostMapping("/admin/addroute/{id}/addstops")
	public ModelAndView addStop(@Valid StopCreationDTO stopCreationDTO, BindingResult result, @PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		log.debug("addStudent Handler method.");
		

		for (ObjectError e : result.getAllErrors()) {
			if (e instanceof FieldError) {
				log.debug(((FieldError) e).getField() + ": " + e.getDefaultMessage());
			}
		}

		if (!result.hasErrors()) {
			stopService.addStop(stopCreationDTO, id);
			response.setViewName("redirect:/admin/addroute/" + id + "/addstops");
			log.debug("Successful added stop");
		} else {
			response.addObject("form", stopCreationDTO);
			for (ObjectError e : result.getAllErrors()) {
				if (e instanceof FieldError) {
					response.addObject(((FieldError) e).getField() + "Message", e.getDefaultMessage());
				}
			}
			response.setViewName("add_stop");
		}
		
		

		return response;
	}
	
	@GetMapping("/admin/resetroutes")
	public ModelAndView resetRoutes() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("admin_dashboard");

		response.addObject("user", currentUser);
		response.addObject("success", routeService.resetRoutes());
		
		return response;
	}
}
