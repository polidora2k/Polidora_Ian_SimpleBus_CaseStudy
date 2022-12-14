package org.ianpolidora.simplebus.database.dao;

import java.util.List;

import org.ianpolidora.simplebus.database.entity.DriverRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRouteDAO extends JpaRepository<DriverRoute, Integer>{
	List<DriverRoute> findByUserId(Integer userId);
	
	@Query("select dr from DriverRoute dr join Route r on r.id = dr.routeId where dr.userId = :driverId and r.status != 'Completed'")
	List<DriverRoute> findInCompleteRoutesByDriver(Integer driverId);
}