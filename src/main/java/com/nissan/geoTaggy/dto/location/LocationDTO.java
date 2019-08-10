package com.nissan.geoTaggy.dto.location;

import com.nissan.geoTaggy.persistence.entities.LocationEntity;

public class LocationDTO {
	protected long locationId;
	protected String name;
	protected double longitude;
	protected double latitude;
	protected long userId;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public LocationDTO(long locationId, double longitude, double latitude) {
		super();
		this.locationId = locationId;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public LocationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	

	@Override
	public String toString() {
		return "LocationDTO [locationId=" + locationId + ", name=" + name + ", longitude=" + longitude + ", latitude="
				+ latitude + ", userId=" + userId + "]";
	}

	
	public LocationDTO(LocationEntity location) {
		this.locationId = location.getId();
		this.name = location.getName();
		this.latitude = location.getLatitude() ;
		this.longitude = location.getLongitude();
		this.userId = location.getUser().getId();
	}

	public LocationDTO(String name, double longitude, double latitude) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	
	 
	

}
