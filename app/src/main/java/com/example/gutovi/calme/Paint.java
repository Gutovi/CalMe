package com.example.gutovi.calme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.graphics.CanvasView;

public class Paint extends AppCompatActivity {

    private CanvasView canvas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        this.canvas = (CanvasView)this.findViewById(R.id.canvas);
    }
}