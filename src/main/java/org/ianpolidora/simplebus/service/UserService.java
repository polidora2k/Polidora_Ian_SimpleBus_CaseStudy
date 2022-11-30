package org.ianpolidora.simplebus.service;

import org.ianpolidora.simplebus.database.dao.UserDAO;
import org.ianpolidora.simplebus.database.entity.User;
import org.ianpolidora.simplebus.dto.UserDTO;
import org.ianpolidora.simplebus.dto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserMapper userMapper;
	
	public Boolean signup(UserDTO userDTO) {
		User existingUser = userDAO.findByEmail(userDTO.getEmail());
		Boolean success = false;
		
		if (existingUser == null) {
			User newUser = userMapper.toUser(userDTO);
			userDAO.save(newUser);
			success = true;
		}
		
		return success;
	}
}
