package edu.temple.colorchangingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ClickInterface {

    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaletteFragment paletteFragment = PaletteFragment.newInstance(3);
        CanvasFragment canvasFragment = CanvasFragment.newInstance(Color.RED);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, paletteFragment)
                .add(R.id.container_2, canvasFragment)
                .commit();

//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
//                intent.putExtra("color", ((ColorDrawable)view.getBackground()).getColor());
//                intent.putExtra("name", ((TextView)view).getText());
//                MainActivity.this.startActivity(intent);
//            }
//        });


//        Intent intent = getIntent();
//
//        layout = findViewById(R.id.layout);
//        layout.setBackgroundColor(intent.getIntExtra(MainActivity.EXTRA_COLOR, Color.WHITE));
//
//        TextView label = findViewById(R.id.label);
//        label.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));

    }

    @Override
    public void click() {

    }
}