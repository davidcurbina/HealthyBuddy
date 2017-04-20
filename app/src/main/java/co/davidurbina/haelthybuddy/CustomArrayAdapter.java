package co.davidurbina.haelthybuddy;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidurbina on 4/20/17.
 */

public class CustomArrayAdapter extends ArrayAdapter<Event> implements View.OnClickListener{

    private ArrayList<Event> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView eventName;
        TextView eventDay;
        TextView eventTime;
    }

    public CustomArrayAdapter(ArrayList<Event> data, Context context) {
        super(context, R.layout.row_event, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Event Event=(Event)object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Event Event = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_event, parent, false);
            viewHolder.eventName = (TextView) convertView.findViewById(R.id.event_name);
            viewHolder.eventDay = (TextView) convertView.findViewById(R.id.event_day);
            viewHolder.eventTime = (TextView) convertView.findViewById(R.id.event_time);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.eventName.setText(Event.getName());
        viewHolder.eventDay.setText(Event.getDay());
        viewHolder.eventTime.setText(Event.getTime());
        // Return the completed view to render on screen
        return convertView;
    }
}