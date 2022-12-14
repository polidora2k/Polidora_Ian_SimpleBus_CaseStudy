package org.ianpolidora.simplebus.service;

import java.util.Optional;

import org.ianpolidora.simplebus.database.dao.RouteDAO;
import org.ianpolidora.simplebus.database.entity.Route;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.dto.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
	@Autowired
	RouteDAO routeDAO;

	@Autowired
	RouteMapper routeMapper;

	public RouteDTO getRoute(Integer id) {
		Optional<Route> route = routeDAO.findById(id);

		if (route.isPresent()) {
			return routeMapper.toRouteDTO(route.get());
		} else {
			return null;
		}
	}

	public void advanceStop(Integer routeId, Integer nextStopId) {
		Optional<Route> route = routeDAO.findById(routeId);

		if (route.isPresent()) {
			Route r = route.get();
			r.setCurrentStopId(nextStopId);;
			routeDAO.save(r);
		}
	}
	
	public void completeRoute(Integer routeId) {
		Optional<Route> route = routeDAO.findById(routeId);
		
		if (route.isPresent()) {
			Route s = route.get();
			s.setStatus("Completed");
			routeDAO.save(s);
		}
	}
}
