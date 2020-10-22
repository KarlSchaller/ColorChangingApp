package edu.temple.colorchangingapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DEFAULT_COLOR = "color";

    // TODO: Rename and change types of parameters
    private int mDefaultColor;

    public CanvasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
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
        View l = inflater.inflate(R.layout.fragment_canvas, container, false);

        l.findViewById(R.id.colorDisplay);

        return l;
    }
}