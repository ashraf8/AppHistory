package ashraf.com.applog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {

    List<ListItems> items;
    LayoutInflater inflater;
    Activity activity;


    public CustomListAdapter(Activity activity,List<ListItems> items)
    {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(activity.getBaseContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.list_row,null);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);
        ImageView img = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView operation = (TextView) convertView.findViewById(R.id.operation);

        String name = items.get(position).name;

        Drawable icon = null;
        try
        {
            icon = activity.getPackageManager().getApplicationIcon(name);

        }catch (Exception ex)
        {
            //ex.printStackTrace();
        }



        if(icon != null)
            img.setImageDrawable(icon);

        operation.setText(items.get(position).operation);
        title.setText(name);
        year.setText(items.get(position).date);

        return convertView;
    }
}
