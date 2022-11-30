package org.ianpolidora.simplebus.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
}
