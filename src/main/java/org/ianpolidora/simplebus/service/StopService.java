package org.ianpolidora.simplebus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ianpolidora.simplebus.database.dao.StopDAO;
import org.ianpolidora.simplebus.database.entity.Stop;
import org.ianpolidora.simplebus.dto.StopCreationDTO;
import org.ianpolidora.simplebus.dto.StopDTO;
import org.ianpolidora.simplebus.dto.mapper.StopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopService {
	
	@Autowired
	StopDAO stopDAO;
	
	@Autowired
	StopMapper stopMapper;
	
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
	
	public List<StopDTO> getUnassignedStops(){
		List<Stop> stops = stopDAO.findByRouteId(null);
		
		return stops.stream().map(s -> stopMapper.toStopDTO(s)).collect(Collectors.toList());
	}
	
	public StopDTO addStop(StopCreationDTO stopCreationDTO) {
		Stop newStop = stopMapper.toStop(stopCreationDTO);
		
		stopDAO.save(newStop);
		
		return stopMapper.toStopDTO(newStop);
	}
}
