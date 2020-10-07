package edu.temple.colorchangingapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PaletteActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_NAME = "name";
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        grid = findViewById(R.id.grid);
        ColorAdapter adapter = new ColorAdapter(this);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra("color", ((ColorDrawable)view.getBackground()).getColor());
                intent.putExtra("name", ((TextView)view).getText());
                PaletteActivity.this.startActivity(intent);
            }
        });
    }
}