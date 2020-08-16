package com.spring.fullstack.app.exception;

import lombok.Getter;

@Getter
public class CapabilityNotFoundResponse {
	private String message;

	public CapabilityNotFoundResponse(String message) {
		super();
		this.message = message;
	}

}
