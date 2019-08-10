package com.nissan.geoTaggy.dto.location;

public class LocationRequestDTO {
	private String name;
	private double longitude;
	private double latitude;

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

	@Override
	public String toString() {
		return "LocationRequestDTO [name=" + name + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	public LocationRequestDTO(String name, double longitude, double latitude) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public LocationRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
