package com.flightcompanion.flightlogbook.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flightcompanion.flightlogbook.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateView extends LinearLayout {

	private TextView monthField;
	private TextView yearField;

	public SimpleDateView(Context context) {
		super(context);
		init(null);
	}

	public SimpleDateView(Context context, AttributeSet attributes) {
		super(context, attributes);
		init(attributes);
	}

	public SimpleDateView(Context context, AttributeSet attributes, int defStyleAttr) {
		super(context, attributes, defStyleAttr);
		init(attributes);
	}

	public void init(AttributeSet attributes) {
		LayoutInflater.from(getContext()).inflate(R.layout.view_date, this);

		monthField = (TextView) findViewById(R.id.month_field);
		yearField = (TextView) findViewById(R.id.year_field);

		applyAttributes(attributes);
	}

	private void applyAttributes(AttributeSet attributes) {
		if (attributes != null) {
			TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(attributes, R.styleable.SimpleDateView, 0, 0);
			try {
				if (styledAttributes.hasValue(R.styleable.SimpleDateView_textColor)) {
					int textColor = styledAttributes.getColor(R.styleable.SimpleDateView_textColor, 0);
					monthField.setTextColor(textColor);
					yearField.setTextColor(textColor);
				}
				if (styledAttributes.hasValue(R.styleable.SimpleDateView_textSize)) {
					float textSize = styledAttributes.getDimension(R.styleable.SimpleDateView_textSize, 0);
					monthField.setTextSize(textSize);
					yearField.setTextSize(textSize);
				}
			} finally {
				styledAttributes.recycle();
			}
		}
	}

	public void setDate(Date date) {
		monthField.setText(new SimpleDateFormat("MMM dd", Locale.US).format(date));
		yearField.setText(new SimpleDateFormat("yyyy", Locale.US).format(date));
	}
}
