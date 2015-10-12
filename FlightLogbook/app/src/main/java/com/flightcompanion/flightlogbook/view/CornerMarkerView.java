package com.flightcompanion.flightlogbook.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.flightcompanion.flightlogbook.R;

public class CornerMarkerView extends View {

	private Path path = new Path();
	private Paint paint = new Paint();
	private int markerColor;

	public CornerMarkerView(Context context) {
		super(context);
		initCustomAttributes(null);
	}

	public CornerMarkerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCustomAttributes(attrs);
	}

	public CornerMarkerView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initCustomAttributes(attrs);
	}

	private void initCustomAttributes(AttributeSet attrs) {
		markerColor = getDefaultMarkerColor();

		if (attrs != null) {
			TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CornerMarkerView, 0, 0);
			try {
				markerColor = styledAttributes.getColor(R.styleable.CornerMarkerView_markerColor, getDefaultMarkerColor());
			} finally {
				styledAttributes.recycle();
			}
		}
	}

	private int getDefaultMarkerColor() {
		return getResources().getColor(R.color.red);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int width = getWidth();
		int height = getHeight();

		path.reset();
		path.lineTo(width, 0);
		path.lineTo(0, height);
		path.lineTo(0, 0);
		path.close();
		paint.setColor(markerColor);

		canvas.drawPath(path, paint);
	}
}
