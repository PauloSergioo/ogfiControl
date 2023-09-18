package com.ogficontrol.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import com.ogficontrol.demo.repositories.UserRepository;
import com.ogficontrol.demo.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.ogficontrol.demo.dto.UserInsertDTO;
import com.ogficontrol.demo.entities.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
	
	@Autowired
	private UserRepository repository;

    @Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		User user = repository.findByEmail(dto.getEmail());
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
