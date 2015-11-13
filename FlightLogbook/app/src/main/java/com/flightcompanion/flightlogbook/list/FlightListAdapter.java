package com.flightcompanion.flightlogbook.list;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flightcompanion.flightlogbook.R;
import com.flightcompanion.flightlogbook.model.FlightRecord;
import com.flightcompanion.flightlogbook.view.FlightDetailView;
import com.flightcompanion.flightlogbook.view.PlaneDetailView;
import com.flightcompanion.flightlogbook.view.SimpleDateView;

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
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_card, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(FlightListAdapter.ViewHolder holder, int position) {
		holder.dateField.setDate(flightRecords.get(position).getDate());
		holder.planeInfo.setPlane(flightRecords.get(position).getPlane());
		holder.flightDetailView.setPerformanceParameters(
			flightRecords.get(position).getDuration(),
			flightRecords.get(position).getDistance(),
			flightRecords.get(position).getMaxAltitude());
		holder.flightDetailView.setRouteDetails(
			flightRecords.get(position).getStartingAirfield(),
			flightRecords.get(position).getDestination());
	}

	@Override
	public int getItemCount() {
		return flightRecords.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		CardView cardView;
		SimpleDateView dateField;
		PlaneDetailView planeInfo;
		FlightDetailView flightDetailView;

		public ViewHolder(View view) {
			super(view);
			cardView = (CardView) view.findViewById(R.id.flight_card);
			dateField = (SimpleDateView) view.findViewById(R.id.date);
			planeInfo = (PlaneDetailView) view.findViewById(R.id.plane_details);
			flightDetailView = (FlightDetailView) view.findViewById(R.id.flight_details);
		}
	}
}
