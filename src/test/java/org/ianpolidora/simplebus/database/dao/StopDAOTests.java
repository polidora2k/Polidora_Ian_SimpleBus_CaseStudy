package org.ianpolidora.simplebus.database.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ianpolidora.simplebus.SimpleBusApplication;
import org.ianpolidora.simplebus.database.entity.Stop;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SimpleBusApplication.class)
class StopDAOTests {
	
	@Autowired
	private StopDAO stopDAO;
	
	@ParameterizedTest
    @CsvFileSource(resources = {"/org/ianpolidora/simplebus/database/dao/allStops.csv"}, delimiter = ',', numLinesToSkip = 1)
	void testFindById(String id, String name, String streetAddress, String city, String state, String zipcode, String status, String routeId, String routeStopNumber) {
		Stop expected = new Stop();
		expected.setId(Integer.parseInt(id));
		expected.setName(name);
		expected.setStreetAddress(streetAddress);
		expected.setCity(city);
		expected.setState(state);
		expected.setZipcode(zipcode);
		expected.setStatus(status);
		expected.setRouteId(routeId == null ? Integer.parseInt(routeId) : null);
		expected.setRouteStopNumber(routeStopNumber == null ? Integer.parseInt(routeStopNumber) : null);
		
		
		Optional<Stop> stop = stopDAO.findById(Integer.parseInt(id));
		
		Stop actual = stop.get();
		
		assertEquals(expected, actual);
	}

}
