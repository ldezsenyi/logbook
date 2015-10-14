package com.flightcompanion.flightlogbook.model;

import java.util.Date;

public class FlightRecord {

	private Date date;
	private Plane plane;
	private Long duration;
	private int distance;
	private String location;
	private String task;
	private String comment;

	public FlightRecord(Date date, Plane plane, Long duration, int distance, String location, String task, String comment) {
		this.date = date;
		this.plane = plane;
		this.duration = duration;
		this.distance = distance;
		this.location = location;
		this.task = task;
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public Long getDuration() {
		return duration;
	}

	public Plane getPlane() {
		return plane;
	}

	public String getLocation() {
		return location;
	}

	public String getTask() {
		return task;
	}

	public String getComment() {
		return comment;
	}

	public int getDistance() {
		return distance;
	}

	public static class Builder {
		private Date date = new Date();
		private Plane plane = new Plane("", "");
		private Long duration;
		private int distance;
		private String location = "";
		private String task = "";
		private String comment = "";

		public Builder(Date date, Plane plane, long duration, String location) {
			this.date = date;
			this.plane = plane;
			this.duration = duration;
			this.location = location;
		}

		public Builder distance(int distance) {
			this.distance = distance;
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
			return new FlightRecord(date, plane, duration, distance, location, task, comment);
		}
	}
}
