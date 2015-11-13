package com.flightcompanion.flightlogbook.model;

public class Plane {

	private String registrationMark;
	private String type;

	public Plane(String registrationMark, String type) {
		this.registrationMark = registrationMark;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getRegistrationMark() {
		return registrationMark;
	}
}
