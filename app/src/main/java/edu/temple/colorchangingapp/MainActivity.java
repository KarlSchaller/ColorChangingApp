package edu.temple.colorchangingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_NAME = "name";
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.palette_label));

        grid = findViewById(R.id.grid);
        ColorAdapter adapter = new ColorAdapter(this);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
//                intent.putExtra("color", ((ColorDrawable)view.getBackground()).getColor());
//                intent.putExtra("name", ((TextView)view).getText());
//                MainActivity.this.startActivity(intent);
            }
        });

//        Intent intent = getIntent();
//
//        layout = findViewById(R.id.layout);
//        layout.setBackgroundColor(intent.getIntExtra(MainActivity.EXTRA_COLOR, Color.WHITE));
//
//        TextView label = findViewById(R.id.label);
//        label.setText(intent.getStringExtra(MainActivity.EXTRA_NAME));

    }
}