package org.ianpolidora.simplebus.database.dao;

import org.ianpolidora.simplebus.database.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopDAO extends JpaRepository<Stop, Integer> {

}
