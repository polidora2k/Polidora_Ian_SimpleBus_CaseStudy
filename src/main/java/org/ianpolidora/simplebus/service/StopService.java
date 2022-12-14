package org.ianpolidora.simplebus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ianpolidora.simplebus.database.dao.StopDAO;
import org.ianpolidora.simplebus.database.dao.StudentDAO;
import org.ianpolidora.simplebus.database.entity.Stop;
import org.ianpolidora.simplebus.dto.StopCreationDTO;
import org.ianpolidora.simplebus.dto.StopDTO;
import org.ianpolidora.simplebus.dto.mapper.StopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.model.LatLng;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StopService {

	@Autowired
	StopDAO stopDAO;

	@Autowired
	StopMapper stopMapper;

	@Autowired
	private MapsService mapsService;
	
	@Autowired
	private StudentDAO studentDAO;

	public StopDTO getStop(Integer id) {
		Optional<Stop> stop = stopDAO.findById(id);

		if (stop.isPresent()) {
			return stopMapper.toStopDTO(stop.get());
		} else {
			return null;
		}
	}

	public List<StopDTO> getRouteStops(Integer routeId) {
		List<Stop> stops = stopDAO.findByRouteIdOrderByRouteStopNumberAsc(routeId);

		return stops.stream().map(s -> stopMapper.toStopDTO(s)).collect(Collectors.toList());
	}
	
	public List<StopDTO> getRouteStopsWithStudents(Integer routeId) {
		List<Stop> stops = stopDAO.findByRouteIdOrderByRouteStopNumberAsc(routeId);
		List<StopDTO> stopDTOs = new ArrayList<StopDTO>();
		
		for (Stop stop : stops) {
			if (studentDAO.countByStopIdAndRiding(stop.getId(), true) > 0) {
				stopDTOs.add(stopMapper.toStopDTO(stop));
			}
		}

		return stopDTOs;
	}
	
	public StopDTO getRouteStopByNumber(Integer routeId, Integer stopNumber) {
		Optional<Stop> stop = stopDAO.findByRouteIdAndRouteStopNumber(routeId, stopNumber);
		
		if (stop.isPresent()) {
			return stopMapper.toStopDTO(stop.get());
		}
		
		return null;
	}

	public List<StopDTO> getUnassignedStops() {
		List<Stop> stops = stopDAO.findByRouteId(null);

		return stops.stream().map(s -> stopMapper.toStopDTO(s)).collect(Collectors.toList());
	}

	public StopDTO addStop(StopCreationDTO stopCreationDTO) {
		Stop newStop = stopMapper.toStop(stopCreationDTO);

		stopDAO.save(newStop);

		return stopMapper.toStopDTO(newStop);
	}

	public List<LatLng> getStopLocations(List<StopDTO> stops) {
		List<LatLng> locations = new ArrayList<LatLng>();

		for (StopDTO stop : stops) {
			String address = stop.getStreetAddress() + " " + stop.getCity() + ", " + stop.getState() + " "
					+ stop.getZipcode();
			locations.add(mapsService.geocodeAddress(address));
			log.debug(address);
		}

		return locations;
	}
	
	public void completeStop(Integer stopId) {
		Optional<Stop> stop = stopDAO.findById(stopId);
		
		if (stop.isPresent()) {
			Stop s = stop.get();
			s.setStatus("Completed");
			stopDAO.save(s);
		}
	}
}
