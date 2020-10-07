package edu.temple.colorchangingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PaletteActivity extends AppCompatActivity {
    
    ConstraintLayout layout;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        layout = findViewById(R.id.layout);
        grid = findViewById(R.id.grid);
        ColorAdapter adapter = new ColorAdapter(this);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                //intent.putExtra("", view.);
                //layout.setBackgroundColor(((ColorDrawable)view.getBackground()).getColor());
                PaletteActivity.this.startActivity(intent);
            }
        });
    }
}