package com.flightcompanion.flightlogbook.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flightcompanion.flightlogbook.R;
import com.flightcompanion.flightlogbook.model.Plane;

public class PlaneDetailView extends RelativeLayout {

	private TextView registrationMarkField;
	private TextView typeField;

	public PlaneDetailView(Context context) {
		super(context);
		init();
	}

	public PlaneDetailView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PlaneDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init() {
		LayoutInflater.from(getContext()).inflate(R.layout.view_plane_detail, this);

		registrationMarkField = (TextView) findViewById(R.id.registration_field);
		typeField = (TextView) findViewById(R.id.type_field);
	}

	public void setPlane(Plane plane) {
		registrationMarkField.setText(plane.getRegistrationMark());
		typeField.setText(plane.getType());
	}
}
