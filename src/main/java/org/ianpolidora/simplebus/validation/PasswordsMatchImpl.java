package org.ianpolidora.simplebus.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.ianpolidora.simplebus.dto.UserCreationDTO;

public class PasswordsMatchImpl implements ConstraintValidator<PasswordsMatch, Object>{
	@Override
	public void initialize(PasswordsMatch constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(Object user, ConstraintValidatorContext context) {
		UserCreationDTO userDTO = (UserCreationDTO) user;
		
		return userDTO.getPassword().equals(userDTO.getConfirmPassword());
	}
}
