package com.nissan.geoTaggy.dto.user;

import java.util.Set;
import java.util.stream.Collectors;

import com.nissan.geoTaggy.dto.location.LocationDTO;
import com.nissan.geoTaggy.persistence.entities.UserEntity;

public class UserDTO {
	protected long userId;
	protected String firstName;
	protected String lastName;
	protected Set<LocationDTO> locations;

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

	public Set<LocationDTO> getLocations() {
		return locations;
	}

	public void setLocations(Set<LocationDTO> locations) {
		this.locations = locations;
	}

	public UserDTO(UserEntity userEntity) {
		this.userId = userEntity.getId();
		this.firstName = userEntity.getFirstName();
		this.lastName = userEntity.getLastName();
		this.locations = userEntity.getLocations().stream()
				   								  .map(location -> new LocationDTO(location))
				   								  .collect(Collectors.toSet());
	}



	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", locations="
				+ locations + "]";
	}

}
