package com.ogficontrol.demo.resources.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationError extends StandardError {

	private final List<FieldMessage> errors = new ArrayList<>();

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
