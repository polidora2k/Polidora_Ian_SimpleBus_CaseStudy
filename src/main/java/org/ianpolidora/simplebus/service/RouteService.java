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
}
