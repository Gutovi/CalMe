package com.example.gutovi.calme;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btnActivity5 = findViewById(R.id.btnActivity5);
        btnActivity5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity5);
            }
        });
    }

    void pressButton(ImageButton btn){

        if (btn.getContentDescription() == getResources().getString(R.string.Drawing))
        {
            Intent intent = new Intent(MainActivity.this, Paint.class);
            startActivity(intent);
        }
    }
}
