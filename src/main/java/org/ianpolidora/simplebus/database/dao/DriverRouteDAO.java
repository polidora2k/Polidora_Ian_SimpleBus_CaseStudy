package org.ianpolidora.simplebus.database.dao;

import java.util.List;

import org.ianpolidora.simplebus.database.entity.DriverRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRouteDAO extends JpaRepository<DriverRoute, Integer>{
	List<DriverRoute> findByUserId(Integer userId);
}