package animelabs.assignment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Asheesh on 9/28/2015.
 */
public class CustomAdapter extends BaseAdapter {
    Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater;

    public CustomAdapter(Activity a,ArrayList<HashMap<String, String>> d)
    {
        activity=a;
        data=d;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            inflater=activity.getLayoutInflater();
        if(convertView==null)
            convertView = inflater.inflate(R.layout.template, null,true);

        TextView title = (TextView)convertView.findViewById(R.id.textView); // title
        TextView artist = (TextView)convertView.findViewById(R.id.textView2); // artist name


        HashMap<String, String> datanew = new HashMap<String, String>();
       datanew = data.get(position);

            // Setting all values in listview
            title.setText(datanew.get(MainActivity.KEY_TITLE));
            artist.setText(datanew.get(MainActivity.KEY_PHOTOS));

        return convertView;
    }
}
