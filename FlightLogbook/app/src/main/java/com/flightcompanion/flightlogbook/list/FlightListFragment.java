package com.flightcompanion.flightlogbook.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flightcompanion.flightlogbook.R;
import com.flightcompanion.flightlogbook.model.FlightRecord;
import com.flightcompanion.flightlogbook.model.Plane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightListFragment extends Fragment {

	public static final String TAG = "FlightListFragment";

	private RecyclerView recyclerView;
	private FlightListAdapter flightListadapter;

	public static FlightListFragment newInstance() {
		return new FlightListFragment();
	}

	public FlightListFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_flight_list, container, false);

		recyclerView = (RecyclerView) view.findViewById(R.id.flight_list);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		recyclerView.setHasFixedSize(true);

		flightListadapter = new FlightListAdapter();
		recyclerView.setAdapter(flightListadapter);

		flightListadapter.setFlightRecords(createFakeFlightRecords());
		flightListadapter.notifyDataSetChanged();

		return view;
	}

	private List<FlightRecord> createFakeFlightRecords() {
		ArrayList<FlightRecord> flightRecords = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			FlightRecord record = new FlightRecord.Builder(new Date(), new Plane("HA-4256", "Astir"), 10, "LHJK").comment("Record item " + i).build();
			flightRecords.add(record);
		}
		return flightRecords;
	}
}
