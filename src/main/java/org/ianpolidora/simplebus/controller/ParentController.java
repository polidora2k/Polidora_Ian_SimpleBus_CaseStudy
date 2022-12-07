package org.ianpolidora.simplebus.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.ianpolidora.simplebus.dto.StudentCreationDTO;
import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.security.AuthenticatedUserService;
import org.ianpolidora.simplebus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ParentController {

	@Autowired
	AuthenticatedUserService aus;

	@Autowired
	ParentService parentService;
	
	@Autowired
	GeoApiContext context;

	@GetMapping("/parent")
	public ModelAndView showParentPage() {
		UserDTO currentUser = aus.getCurrentUser();
		ModelAndView response = new ModelAndView();
		response.setViewName("parent_dashboard");

		response.addObject("students", parentService.getAllStudents(aus.getCurrentUser().getId()));

		response.addObject("user", currentUser);

		log.debug(context.toString());
		GeocodingResult[] results;
		try {
			results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
			for (GeocodingResult gr : results) {
				log.debug(gr.toString());
			}
		} catch (ApiException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
			results = new GeocodingResult[1];
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
			results = new GeocodingResult[1];
		} catch (IOException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
			results = new GeocodingResult[1];
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		log.debug("gson: " + gson.toJson(results[0].geometry.location));

		// Invoke .shutdown() after your application is done making requests
		context.shutdown();

		return response;
	}

	@GetMapping("/parent/addstudent")
	public ModelAndView showAddStudentPage() {
		ModelAndView response = new ModelAndView();
		response.setViewName("add_student");

		return response;
	}

	@PostMapping("/parent/addstudent")
	public ModelAndView addStudent(@Valid StudentCreationDTO studentCreationDTO, BindingResult result) {
		ModelAndView response = new ModelAndView();
		log.debug("addStudent Handler method.");
		response.addObject("form", studentCreationDTO);

		for (ObjectError e : result.getAllErrors()) {
			if (e instanceof FieldError) {
				log.debug(((FieldError) e).getField() + ": " + e.getDefaultMessage());
			}
		}

		if (!result.hasErrors()) {
			parentService.addStudent(studentCreationDTO, aus.getCurrentUser().getId());

			response.setViewName("redirect:/parent");
			log.debug("Successful added student");
		} else {
			for (ObjectError e : result.getAllErrors()) {
				if (e instanceof FieldError) {
					response.addObject(((FieldError) e).getField() + "Message", e.getDefaultMessage());
				}
			}

			response.setViewName("add_student");
		}

		return response;
	}
}
