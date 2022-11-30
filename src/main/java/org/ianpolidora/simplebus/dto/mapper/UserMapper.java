package org.ianpolidora.simplebus.dto.mapper;

import org.ianpolidora.simplebus.database.dao.RoleDAO;
import org.ianpolidora.simplebus.database.entity.Role;
import org.ianpolidora.simplebus.database.entity.User;
import org.ianpolidora.simplebus.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	@Autowired
	private RoleDAO roleDAO;
	
	public UserDTO toUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole().getName());
		
		return userDTO;
	}
	
	public User toUser(UserDTO userDTO) {
		User user = new User();
		
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		
		Role role = roleDAO.findByName(userDTO.getRole());
		
		user.setRole(role);
		
		return user;
	}
}
