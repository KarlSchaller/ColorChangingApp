package edu.temple.colorchangingapp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * A fragment representing a list of Items.
 */
public class PaletteFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 3;

    ClickInterface parentActivity;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PaletteFragment() {
    }

    @SuppressWarnings("unused")
    public static PaletteFragment newInstance(int columnCount) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ClickInterface)
            parentActivity = (ClickInterface) context;
        else
            throw new RuntimeException("You must implement the asdfas interface to attach this fragment");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args;
        if ((args = getArguments()) != null) {
            mColumnCount = args.getInt(ARG_COLUMN_COUNT);
        }
        else {
            mColumnCount = 3;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette_list, container, false);

//        return inflater.inflate(R.layout.activity_main, container, false);

        // Set the adapter
        if (view instanceof GridView) {
            Context context = view.getContext();
            GridView gridView = (GridView) view;

            gridView.setNumColumns(mColumnCount);
            gridView.setAdapter(new ColorAdapter(context));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        parentActivity.click(((ColorDrawable)textView.getBackground()).getColor(), textView.getText());
                    }
                }
            });
        }

        return view;
    }

    interface ClickInterface {
        void click(int color, CharSequence text);
    }
}