package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class TabFragment2 extends Fragment {

    Spinner daySpinner;
    Spinner typeSpinner;
    ArrayList<String> days;
    ArrayList<String> types;
    ListView listView;
    ArrayList<Event> events;
    Button search;
    private static CustomArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);

        days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        types = new ArrayList<String>();
        types.add("Weight Loss");
        types.add("Strength Training");

        daySpinner = (Spinner) v.findViewById(R.id.days_spinner);
        typeSpinner = (Spinner) v.findViewById(R.id.type_spinner);
        listView=(ListView)v.findViewById(R.id.list_view);
        search = (Button) v.findViewById(R.id.search_button);

        ArrayAdapter day_adapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1,days);
        daySpinner.setAdapter(day_adapter);


        ArrayAdapter type_adapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1,types);
        typeSpinner.setAdapter(type_adapter);

        events = new ArrayList<Event>();

        adapter= new CustomArrayAdapter(events,v.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Events","Events clicked");
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEvents();
                Log.i("Frag2","Button Clicked");
            }
        });
        return v;
    }

    public void getEvents() {
        events.add(new Event("Zoomba","Public","Today","5:00 PM"));
        events.add(new Event("Cardio","Public","Tuesday","5:00 PM"));
        events.add(new Event("Insanity","Public","Friday","6:00 PM"));
        Log.i("Frag2",events.size()+"");
        adapter.notifyDataSetChanged();
    }
}