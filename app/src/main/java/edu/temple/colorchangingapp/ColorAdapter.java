package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter {

    Context context;
    private String[] colors;

    public ColorAdapter(Context context) {
        super();

        this.context = context;

        Resources res = context.getResources();
        colors = res.getStringArray(R.array.colors);
//        this.colors.add("Black");
//        this.colors.add("Transparent");
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
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
        textView.setText(getItem(position).toString());

        if (textView.getText().equals(colors[0]))
            textView.setBackgroundColor(Color.WHITE);
//        else if (textView.getText().equals("Black"))
//            textView.setBackgroundColor(Color.BLACK);
        else if (textView.getText().equals(colors[1]))
            textView.setBackgroundColor(Color.BLUE);
        else if (textView.getText().equals(colors[2]))
            textView.setBackgroundColor(Color.CYAN);
        else if (textView.getText().equals(colors[3]))
            textView.setBackgroundColor(Color.DKGRAY);
        else if (textView.getText().equals(colors[4]))
            textView.setBackgroundColor(Color.GRAY);
        else if (textView.getText().equals(colors[5]))
            textView.setBackgroundColor(Color.GREEN);
        else if (textView.getText().equals(colors[6]))
            textView.setBackgroundColor(Color.LTGRAY);
        else if (textView.getText().equals(colors[7]))
            textView.setBackgroundColor(Color.MAGENTA);
        else if (textView.getText().equals(colors[8]))
            textView.setBackgroundColor(Color.RED);
//        else if (textView.getText().equals("Transparent"))
//            textView.setBackgroundColor(Color.TRANSPARENT);
        else if (textView.getText().equals(colors[9]))
            textView.setBackgroundColor(Color.YELLOW);
        else if (textView.getText().equals(colors[10]))
            textView.setBackgroundColor(Color.parseColor("#964B00"));
        else if (textView.getText().equals(colors[11]))
            textView.setBackgroundColor(Color.parseColor("#FFA500"));

        return textView;
    }
}