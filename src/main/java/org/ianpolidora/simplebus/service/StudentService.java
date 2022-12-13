package org.ianpolidora.simplebus.service;

import java.util.List;
import java.util.Optional;

import org.ianpolidora.simplebus.database.dao.StudentDAO;
import org.ianpolidora.simplebus.database.entity.Student;
import org.ianpolidora.simplebus.dto.RouteDTO;
import org.ianpolidora.simplebus.dto.StopDTO;
import org.ianpolidora.simplebus.dto.StudentDTO;
import org.ianpolidora.simplebus.dto.StudentStatusDTO;
import org.ianpolidora.simplebus.dto.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	StopService stopService;
	
	@Autowired
	private RouteService routeService;

	public StudentDTO getStudent(Integer id) {
		Optional<Student> s = studentDAO.findById(id);
		StudentDTO sd = new StudentDTO();

		if (s.isPresent()) {
			sd = studentMapper.toStudentDTO(s.get());
		}

		return sd;
	}

	public StudentStatusDTO getStudentStatus(StudentDTO student) {
		StudentStatusDTO status = new StudentStatusDTO();
		StopDTO stop = stopService.getStop(student.getStopId());
		RouteDTO route = routeService.getRoute(stop.getRouteId());

		List<StopDTO> stops = route.getStops().subList(0, stop.getRouteStopNumber());
		StopDTO currentStop = stopService.getStop(route.getCurrentStopId());
		status.setCurrentStop(currentStop);

		if (stop.getId() == route.getCurrentStopId() || !stops.contains(currentStop)) {
			status.setArrived(true);
		} else {
			status.setArrived(false);
		}

		Integer segment = 100 / stops.size();

		Integer current = stops.indexOf(currentStop) + 1;

		status.setPercent((segment) * (current));

		return status;
	}
	
	public void changeRiding(Integer id, Boolean riding) {
		Optional<Student> student = studentDAO.findById(id);
		
		if(student.isPresent()) {
			Student s = student.get();
			s.setRiding(riding);
			studentDAO.save(s);
		}
	}
}
