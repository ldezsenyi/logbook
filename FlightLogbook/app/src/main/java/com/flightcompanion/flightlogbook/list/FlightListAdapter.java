package com.flightcompanion.flightlogbook.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flightcompanion.flightlogbook.model.FlightRecord;

import java.util.ArrayList;
import java.util.List;

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.ViewHolder> {

	private List<FlightRecord> flightRecords;

	public FlightListAdapter() {
		flightRecords = new ArrayList<>();
	}

	public void setFlightRecords(List<FlightRecord> flightRecords) {
		this.flightRecords = flightRecords;
	}

	@Override
	public FlightListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(new TextView(parent.getContext()));
	}

	@Override
	public void onBindViewHolder(FlightListAdapter.ViewHolder holder, int position) {
		holder.descriptionText.setText(flightRecords.get(position).getComment());
	}

	@Override
	public int getItemCount() {
		return flightRecords.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		TextView descriptionText;

		public ViewHolder(View view) {
			super(view);
			descriptionText = (TextView) view;
		}
	}
}
