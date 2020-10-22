package edu.temple.colorchangingapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DEFAULT_COLOR = "color";
    private int mDefaultColor;

    View l;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(int defaultColor) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DEFAULT_COLOR, defaultColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args;
        if ((args = getArguments()) != null) {
            mDefaultColor = args.getInt(ARG_DEFAULT_COLOR);
        }
        else {
            mDefaultColor = Color.BLACK;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_canvas, container, false);

        changeColor(Color.BLUE);
        changeText("test");

        return l;
    }

    public void changeColor(int color) {
        if (l instanceof TextView) {
            TextView textView = (TextView) l;
            textView.setBackgroundColor(color);
        }
    }

    public void changeText(String text) {
        if (l instanceof TextView) {
            TextView textView = (TextView) l;
            textView.setText(text);
        }
    }
}