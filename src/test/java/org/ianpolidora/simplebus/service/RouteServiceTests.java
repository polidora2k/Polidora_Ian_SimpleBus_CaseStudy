package org.ianpolidora.simplebus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.ianpolidora.simplebus.SimpleBusApplication;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SimpleBusApplication.class)
class RouteServiceTests {
	
	@Autowired
	private RouteService routeService;

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testStartRoute(int routeId) {
		routeService.startRoute(routeId);
		
		RouteDTO actual = routeService.getRoute(routeId);
		
		assertEquals("In Progress", actual.getStatus());
		
		routeService.resetRoutes();
	}

}
