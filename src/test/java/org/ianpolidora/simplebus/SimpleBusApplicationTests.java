package org.ianpolidora.simplebus;

import static org.junit.jupiter.api.Assertions.*;

import org.ianpolidora.simplebus.database.entity.UserRole;
import org.ianpolidora.simplebus.database.entity.User;
import org.ianpolidora.simplebus.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleBusApplicationTests {
	ModelMapper mapper;
	
	@BeforeEach
	public void setup() {
	    this.mapper = new ModelMapper();
	    
	}

	@Test
	public void whenMapGameWithExactMatch_thenConvertsToDTO() {
	    // when similar source object is provided
	    User user = new User(1, "Ian", "Polidora", "polidora2k@gmail.com", "1234");
	    UserDTO userDTO = this.mapper.map(user, UserDTO.class);
	    
	    // then it maps by default
	    assertEquals(user.getEmail(), userDTO.getEmail());
	    assertEquals(user.getFirstName(), userDTO.getFirstName());
	}

}
