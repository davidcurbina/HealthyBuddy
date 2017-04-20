package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TabFragment1 extends Fragment {
    ArrayList<Event> events;
    ListView listView;
    private static CustomArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_1, container, false);
        listView=(ListView)v.findViewById(R.id.list_view);

        events = new ArrayList<Event>();
        events.add(new Event("Zoomba","Public","Today","5:00 PM"));
        events.add(new Event("Cardio","Public","Tuesday","5:00 PM"));
        events.add(new Event("Insanity","Public","Friday","6:00 PM"));

        adapter= new CustomArrayAdapter(events,v.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Event dataModel= events.get(position);

            }
        });

        return v;
    }
}