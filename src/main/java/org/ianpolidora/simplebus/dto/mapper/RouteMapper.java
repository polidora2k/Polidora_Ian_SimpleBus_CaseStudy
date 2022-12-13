package org.ianpolidora.simplebus.dto.mapper;

import org.ianpolidora.simplebus.database.entity.Route;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.service.StopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private StopService stopService;
	
	public RouteDTO toRouteDTO(Route route) {
		RouteDTO routeDTO = mapper.map(route, RouteDTO.class);
		
		routeDTO.setStops(stopService.getRouteStops(routeDTO.getId()));
		
		return routeDTO;
	}

	public Route toRoute(RouteDTO routeDTO) {
		return mapper.map(routeDTO, Route.class);
	}
}
