package org.ianpolidora.simplebus.controller;

import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.dto.StopDTO;
import org.ianpolidora.simplebus.dto.StudentDTO;
import org.ianpolidora.simplebus.service.RouteService;
import org.ianpolidora.simplebus.service.StopService;
import org.ianpolidora.simplebus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StopService stopService;
	
	@Autowired
	RouteService routeService;
	
	@GetMapping("/parent/student/{id}")
	public ModelAndView getStudent(@PathVariable Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("student");
		
		StudentDTO sd = studentService.getStudent(id);
		
		StopDTO stop = stopService.getStop(sd.getStopId());
		
		RouteDTO route = routeService.getRoute(stop.getRouteId());
		
		response.addObject("student", sd);
		response.addObject("route", route);
		response.addObject("stop", stop);
		response.addObject("status", studentService.getStudentStatus(sd));
		
		return response;
	}
	
	@ResponseBody
	@GetMapping("/changeriding")
	public void ajaxCall(@RequestParam Integer id, @RequestParam Boolean riding) {
		studentService.changeRiding(id, riding);
	}
}
