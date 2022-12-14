package org.ianpolidora.simplebus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.ianpolidora.simplebus.database.dao.DriverRouteDAO;
import org.ianpolidora.simplebus.database.entity.DriverRoute;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DriverService {
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private DriverRouteDAO driverRouteDAO;

	public List<RouteDTO> getRoutesForDriver(Integer driverId) {
		List<DriverRoute> driverRoutes = driverRouteDAO.findInCompleteRoutesByDriver(driverId);
		List<RouteDTO> routes = driverRoutes.stream().map(dr -> routeService.getRoute(dr.getUserId())).collect(Collectors.toList());

		return routes;
	}
}
