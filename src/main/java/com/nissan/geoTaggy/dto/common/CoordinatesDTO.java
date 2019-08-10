package com.nissan.geoTaggy.dto.common;

public class CoordinatesDTO {
	private double xCoordinate;
	private double yCoordinate;

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	@Override
	public String toString() {
		return "CoordinatesDto [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}

	public CoordinatesDTO(double xCoordinate, double yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public CoordinatesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
