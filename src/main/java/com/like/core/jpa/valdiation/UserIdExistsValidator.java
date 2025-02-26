package com.like.core.jpa.valdiation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;
import com.like.system.user.domain.port.out.SystemUserCommandDbPort;

@Component
public class UserIdExistsValidator implements ConstraintValidator<UserIdExists, SystemUserId> {
	
	private SystemUserCommandDbPort userService;
	
	public UserIdExistsValidator(SystemUserCommandDbPort userService) {
		this.userService = userService;
	}
	
	@Override
	public void initialize(UserIdExists constraintAnnotation) {	
	}
	
	@Override
	public boolean isValid(SystemUserId value, ConstraintValidatorContext context) {

		SystemUser user = this.userService.select(value.getUserId());
		
		if (user == null) {
			context.buildConstraintViolationWithTemplate("test message")
				   .addConstraintViolation();
			return false;			
		}
		
		return true;
	}	
}
