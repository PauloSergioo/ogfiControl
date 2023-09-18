package com.ogficontrol.demo.resources.exceptions;

import lombok.Data;

import java.io.Serializable;

@Data
public class FieldMessage implements Serializable {

	private String fieldName;
	private String message;

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
}
