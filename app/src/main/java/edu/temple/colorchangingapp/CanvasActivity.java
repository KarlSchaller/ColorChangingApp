package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        setTitle(getString(R.string.canvas_label));

        Intent intent = getIntent();

        layout = findViewById(R.id.layout);
        layout.setBackgroundColor(intent.getIntExtra(PaletteActivity.EXTRA_COLOR, Color.WHITE));

        TextView label = findViewById(R.id.label);
        label.setText(intent.getStringExtra(PaletteActivity.EXTRA_NAME));
    }
}