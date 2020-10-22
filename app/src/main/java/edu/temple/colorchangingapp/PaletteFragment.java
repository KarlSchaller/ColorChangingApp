package edu.temple.colorchangingapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.temple.colorchangingapp.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class PaletteFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;

    myInterface parentActivity;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PaletteFragment() {
    }

    // TODO: Customize parameter initialization
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

        if (context instanceof myInterface)
            parentActivity = (myInterface) context;
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

//        GridView grid = findViewById(R.id.grid);
//        GridView gridView = new GridView();
//        ColorAdapter adapter = new ColorAdapter(this);
//        gridView.setAdapter(adapter);
//        return inflater.inflate(R.layout.activity_main, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyColorRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }

    interface myInterface { //todo
        void myMethod();
    }
}