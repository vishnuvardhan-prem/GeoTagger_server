package com.nissan.geoTaggy.dto.common;

public class ErrorCodeResponse {
	private String message;
	private String description;

	public ErrorCodeResponse(String message, String description) {
		this.setMessage(message);
		this.setDescription(description);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
