package org.ianpolidora.simplebus.service;

import java.util.List;
import java.util.Optional;

import org.ianpolidora.simplebus.database.dao.RouteDAO;
import org.ianpolidora.simplebus.database.entity.Route;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.dto.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RouteService {
	@Autowired
	RouteDAO routeDAO;

	@Autowired
	RouteMapper routeMapper;
	
	@Autowired
	StopService stopService;

	public RouteDTO getRoute(Integer id) {
		Optional<Route> route = routeDAO.findById(id);

		if (route.isPresent()) {
			return routeMapper.toRouteDTO(route.get());
		} else {
			log.warn("No user found for id: " + id);
			return null;
		}
	}

	public void advanceStop(Integer routeId, Integer previousStopId) {
		Optional<Route> route = routeDAO.findById(routeId);

		if (route.isPresent()) {
			Route r = route.get();
			r.setLastCompletedStopId(previousStopId);;
			routeDAO.save(r);
		}
	}
	
	public void completeRoute(Integer routeId) {
		Optional<Route> route = routeDAO.findById(routeId);
		
		if (route.isPresent()) {
			Route r = route.get();
			r.setStatus("Completed");
			routeDAO.save(r);
		}
	}
	
	public void startRoute(Integer routeId) {
		Optional<Route> route = routeDAO.findById(routeId);
		
		if (route.isPresent()) {
			Route r = route.get();
			r.setStatus("In Progress");
			routeDAO.save(r);
		}
	}
	
	public RouteDTO addRoute(String routeName) {
		Route route = new Route();
		route.setName(routeName);
		route.setStatus("Not Departed");
		
		routeDAO.save(route);
		
		return routeMapper.toRouteDTO(route);
	}
	
	public Boolean resetRoutes(){
		List<Route> routes = routeDAO.findAll();
		
		for (Route r : routes) {
			r.setStatus("Not Departed");
			r.setLastCompletedStopId(null);
			routeDAO.save(r);
			
			stopService.resetStopsForRoute(r.getId());
		}
		
		return true;
	}
}
