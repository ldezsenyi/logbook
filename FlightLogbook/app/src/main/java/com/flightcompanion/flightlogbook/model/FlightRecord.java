package com.flightcompanion.flightlogbook.model;

import java.util.Date;

public class FlightRecord {

	private Date date;
	private Long duration;
	private Plane plane;
	private String location;
	private String task;
	private String comment;

	public FlightRecord(Date date, Long duration, Plane plane, String location, String task, String comment) {
		this.date = date;
		this.duration = duration;
		this.plane = plane;
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

	public static class Builder {
		private Date date = new Date();
		private Long duration;
		private Plane plane = new Plane("", "");
		private String location = "";
		private String task = "";
		private String comment = "";

		public Builder(Date date, Plane plane, long duration, String location) {
			this.date = date;
			this.plane = plane;
			this.duration = duration;
			this.location = location;
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
			return new FlightRecord(date, duration, plane, location, task, comment);
		}
	}
}
