package org.ianpolidora.simplebus.dto.mapper;

import org.ianpolidora.simplebus.database.entity.Stop;
import org.ianpolidora.simplebus.dto.StopCreationDTO;
import org.ianpolidora.simplebus.dto.StopDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopMapper {
	@Autowired
	private ModelMapper mapper;

	public StopDTO toStopDTO(Stop stop) {
		return mapper.map(stop, StopDTO.class);
	}

	public Stop toStop(StopDTO stopDTO) {
		return mapper.map(stopDTO, Stop.class);
	}
	
	public Stop toStop(StopCreationDTO stopCreationDTO) {
		return mapper.map(stopCreationDTO, Stop.class);
	}
}
