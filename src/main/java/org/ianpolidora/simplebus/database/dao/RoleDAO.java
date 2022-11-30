package org.ianpolidora.simplebus.database.dao;

import org.ianpolidora.simplebus.database.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {
	public Role findByName(String name);
}
