package com.nissan.geoTaggy.model;

public class Coordinates {
	private double latitude;
	private double longitude;
	
	public Coordinates() {
		super();
	}
	
	public Coordinates(double xCoordinate, double yCoordinate) {
		super();
		latitude = xCoordinate;
		longitude = yCoordinate;
	}
	
	public double getXCoordinate() {
		return latitude;
	}

	public void setXCoordinate(double xCoordinate) {
		latitude = xCoordinate;
	}
	

	public double getYCoordinate() {
		return longitude;
	}

	public void setYCoordinate(double yCoordinate) {
		longitude = yCoordinate;
	}

}
