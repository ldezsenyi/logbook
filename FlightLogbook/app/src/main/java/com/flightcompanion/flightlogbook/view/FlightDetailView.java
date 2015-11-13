package com.flightcompanion.flightlogbook.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flightcompanion.flightlogbook.R;
import com.flightcompanion.flightlogbook.model.AirField;

public class FlightDetailView extends RelativeLayout {

	private TextView durationField;
	private TextView distanceField;
	private TextView altitudeField;
	private TextView routeDetails;

	public FlightDetailView(Context context) {
		super(context);
		init();
	}

	public FlightDetailView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public FlightDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init() {
		LayoutInflater.from(getContext()).inflate(R.layout.view_flight_details, this);

		durationField = (TextView) findViewById(R.id.duration);
		distanceField = (TextView) findViewById(R.id.distance);
		altitudeField = (TextView) findViewById(R.id.altitude);
		routeDetails = (TextView) findViewById(R.id.route_details);
	}

	public void setPerformanceParameters(long durationMillis, int distance, int altitude) {
		durationField.setText(String.valueOf(durationMillis));
		distanceField.setText(distance + " km");
		altitudeField.setText(altitude + "m");
	}

	public void setRouteDetails(AirField start, AirField destination) {
		routeDetails.setText(start.getICAOCode() + " - " + destination.getICAOCode());
	}
}
