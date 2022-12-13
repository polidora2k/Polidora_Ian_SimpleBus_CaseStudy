package org.ianpolidora.simplebus.database.dao;

import java.util.Optional;

import org.ianpolidora.simplebus.database.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer> {
	public Optional<Route> findById(Integer id);
	
}
