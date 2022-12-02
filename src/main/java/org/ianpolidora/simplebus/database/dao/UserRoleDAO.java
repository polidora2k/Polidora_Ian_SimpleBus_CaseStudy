package org.ianpolidora.simplebus.database.dao;

import java.util.List;

import org.ianpolidora.simplebus.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {
	public List<UserRole> findByUserId(Integer userId);
}
