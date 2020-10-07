package edu.temple.colorchangingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter {

    Context context;
    private ArrayList<String> colors;

    public ColorAdapter(Context context) {
        super();
        colors = new ArrayList<>();
        this.context = context;
        this.colors.add("White");
//        this.colors.add("Black");
        this.colors.add("Blue");
        this.colors.add("Cyan");
        this.colors.add("Dark Gray");
        this.colors.add("Gray");
        this.colors.add("Green");
        this.colors.add("Light Gray");
        this.colors.add("Magenta");
        this.colors.add("Red");
//        this.colors.add("Transparent");
        this.colors.add("Yellow");
        this.colors.add("Brown");
        this.colors.add("Orange");
    }

    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Object getItem(int position) {
        return colors.get(position);
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
        }
        else
            textView = (TextView) convertView;
        textView.setText(getItem(position).toString());

        if (textView.getText().equals("White"))
            textView.setBackgroundColor(Color.WHITE);
//        else if (textView.getText().equals("Black"))
//            textView.setBackgroundColor(Color.BLACK);
        else if (textView.getText().equals("Blue"))
            textView.setBackgroundColor(Color.BLUE);
        else if (textView.getText().equals("Cyan"))
            textView.setBackgroundColor(Color.CYAN);
        else if (textView.getText().equals("Dark Gray"))
            textView.setBackgroundColor(Color.DKGRAY);
        else if (textView.getText().equals("Gray"))
            textView.setBackgroundColor(Color.GRAY);
        else if (textView.getText().equals("Green"))
            textView.setBackgroundColor(Color.GREEN);
        else if (textView.getText().equals("Light Gray"))
            textView.setBackgroundColor(Color.LTGRAY);
        else if (textView.getText().equals("Magenta"))
            textView.setBackgroundColor(Color.MAGENTA);
        else if (textView.getText().equals("Red"))
            textView.setBackgroundColor(Color.RED);
//        else if (textView.getText().equals("Transparent"))
//            textView.setBackgroundColor(Color.TRANSPARENT);
        else if (textView.getText().equals("Yellow"))
            textView.setBackgroundColor(Color.YELLOW);
        else if (textView.getText().equals("Brown"))
            textView.setBackgroundColor(Color.parseColor("#964B00"));
        else if (textView.getText().equals("Orange"))
            textView.setBackgroundColor(Color.parseColor("#FFA500"));

        return textView;
    }
}