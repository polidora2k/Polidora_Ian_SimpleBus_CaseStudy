package org.ianpolidora.simplebus.database.dao;

import org.ianpolidora.simplebus.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
	
}