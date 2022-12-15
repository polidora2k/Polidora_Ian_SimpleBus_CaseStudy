package org.ianpolidora.simplebus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.ianpolidora.simplebus.SimpleBusApplication;
import org.ianpolidora.simplebus.database.dao.StudentDAO;
import org.ianpolidora.simplebus.dto.StudentCreationDTO;
import org.ianpolidora.simplebus.dto.StudentDTO;
import org.ianpolidora.simplebus.dto.mapper.StudentMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SimpleBusApplication.class)
class ParentServiceTests {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@ParameterizedTest
	@ValueSource(strings = {"Tim,Jenkins,123 Main Street,Ambridge,PA,15643", "Hank,Smith,412 Burgh Street,Pittsburgh,PA,17865"})
	void testCreateStudent(String studentInfo) {
		String[] info = studentInfo.split(",");
		StudentCreationDTO student = new StudentCreationDTO();
		student.setFirstName(info[0]);
		student.setLastName(info[1]);
		student.setStreetAddress(info[2]);
		student.setCity(info[3]);
		student.setState(info[4]);
		student.setZipcode(info[5]);
		
		StudentDTO expected = parentService.addStudent(student, 1);
		
		StudentDTO actual = studentService.getStudent(expected.getId());
		
		studentDAO.deleteById(actual.getId());
		
		assertEquals(expected, actual);
		
	}

}
