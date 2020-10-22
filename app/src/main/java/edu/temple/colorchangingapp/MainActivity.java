package edu.temple.colorchangingapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ClickInterface {

    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getResources();
        String[] color_ids = res.getStringArray(R.array.colors);
        int[] color_vals = {Color.WHITE, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY,
                Color.GREEN, Color.LTGRAY, Color.MAGENTA, Color.RED, Color.YELLOW,
                Color.parseColor("#964B00"), Color.parseColor("#FFA500")};

        PaletteFragment paletteFragment = PaletteFragment.newInstance(3, color_ids, color_vals);
        canvasFragment = new CanvasFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .add(R.id.container_2, canvasFragment)
                .commit();
    }

    @Override
    public void click(int color, CharSequence text) {
        canvasFragment.changeColor(color);
        canvasFragment.changeText(text);
    }
}