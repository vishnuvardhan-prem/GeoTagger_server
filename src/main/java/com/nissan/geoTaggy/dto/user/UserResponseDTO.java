package com.nissan.geoTaggy.dto.user;

import com.nissan.geoTaggy.persistence.entities.UserEntity;

public class UserResponseDTO {

	protected long userId;
	protected String firstName;
	protected String lastName;
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public UserResponseDTO(UserEntity user) {
		this.userId = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}
	
	
	
}
