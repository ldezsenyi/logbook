package com.flightcompanion.flightlogbook.model;

import java.util.Date;

public class FlightRecord {

	private Date date;
	private Plane plane;
	private Long duration;
	private int distance;
	private int maxAltitude;
	private AirField startingAirfield;
	private AirField destination;
	private String task;
	private String comment;

	public FlightRecord(Date date, Plane plane, Long duration, int distance, int maxAltitude, AirField startingAirfiled,
						AirField destination, String task, String comment) {
		this.date = date;
		this.plane = plane;
		this.duration = duration;
		this.distance = distance;
		this.maxAltitude = maxAltitude;
		this.startingAirfield = startingAirfiled;
		this.destination = destination;
		this.task = task;
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public Plane getPlane() {
		return plane;
	}

	public Long getDuration() {
		return duration;
	}

	public int getDistance() {
		return distance;
	}

	public int getMaxAltitude() {
		return maxAltitude;
	}

	public AirField getStartingAirfield() {
		return startingAirfield;
	}

	public AirField getDestination() {
		return destination;
	}

	public String getTask() {
		return task;
	}

	public String getComment() {
		return comment;
	}

	public static class Builder {
		private Date date = new Date();
		private Plane plane = new Plane("", "");
		private Long duration;
		private int distance;
		private int maxAltitude;
		private AirField startingAirfield = new AirField("");
		private AirField destination = new AirField("");
		private String task = "";
		private String comment = "";

		public Builder(Date date, Plane plane, long duration) {
			this.date = date;
			this.plane = plane;
			this.duration = duration;
		}

		public Builder distance(int distance) {
			this.distance = distance;
			return this;
		}

		public Builder maxAltitude(int maxAltitude) {
			this.maxAltitude = maxAltitude;
			return this;
		}

		public Builder startingAirField(AirField startingAirfield) {
			this.startingAirfield = startingAirfield;
			return this;
		}

		public Builder destination(AirField destination) {
			this.destination = destination;
			return this;
		}

		public Builder task(String task) {
			this.task = task;
			return this;
		}

		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}

		public FlightRecord build() {
			return new FlightRecord(date, plane, duration, distance, maxAltitude, startingAirfield, destination, task, comment);
		}
	}
}
