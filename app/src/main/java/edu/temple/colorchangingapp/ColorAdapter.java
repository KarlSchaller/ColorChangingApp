package edu.temple.colorchangingapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    private String[] colorNames;
    private int[] colorValues;

    public ColorAdapter(Context context, String[] colorNames, int[] colorValues) {
        super();

        this.context = context;
        this.colorNames = colorNames;
        this.colorValues = colorValues;
//        this.colors.add("Black");
//        this.colors.add("Transparent");
    }

    @Override
    public int getCount() {
        return colorNames.length;
    }

    @Override
    public Object getItem(int position) {
        return colorNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
            textView.setTextSize(20);
            textView.setPadding(8, 8, 8, 8);
            textView.setHeight(150);
        }
        else
            textView = (TextView) convertView;
        textView.setText(colorNames[position]);
        textView.setBackgroundColor(colorValues[position]);

        return textView;
    }
}