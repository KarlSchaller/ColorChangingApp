package edu.temple.colorchangingapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    View l;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_canvas, container, false);

        return l;
    }

    public void changeColor(int color) {
        if (l instanceof TextView) {
            TextView textView = (TextView) l;
            textView.setBackgroundColor(color);
        }
    }

    public void changeText(CharSequence text) {
        if (l instanceof TextView) {
            TextView textView = (TextView) l;
            textView.setText(text);
        }
    }
}