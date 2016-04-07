package edu.showcase.system.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.showcase.auth.service.User;

public class LoginValidator implements Validator {

	Logger logger = LoggerFactory.getLogger(LoginValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		
		logger.debug("LoginValidator->supports");
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("LoginValidator->validate");

		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		
		if(user.getDept() == null) {
			errors.rejectValue("password", "password required");
		}
		
	}

}
