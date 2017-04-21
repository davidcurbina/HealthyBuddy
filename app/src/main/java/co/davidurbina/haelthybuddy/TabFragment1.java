package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
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

        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Frag1","Clcik");
                Event data = events.get(i);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.NAME_EXTRA,data.getName());
                intent.putExtra(DetailActivity.TYPE_EXTRA,data.getType());
                intent.putExtra(DetailActivity.DAY_EXTRA,data.getDay());
                intent.putExtra(DetailActivity.TIME_EXTRA,data.getTime());
                startActivity(intent);
            }
        });
        return v;
    }
}