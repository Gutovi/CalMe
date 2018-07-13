package com.example.gutovi.calme;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {




    LinearLayout lytStart;
    LinearLayout lytEmotion;
    LinearLayout lytActivity;
    LinearLayout lytDone;
    LinearLayout lytCounting;
    Button btnDone;
    Button btnAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity1);
            }
        });
        final ImageButton btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity2);
            }
        });
        final ImageButton btnActivity3 = findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity3);
            }
        });
        final ImageButton btnActivity4 = findViewById(R.id.btnActivity4);
        btnActivity4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity4);
            }
        });
        final ImageButton btnActivity5 = findViewById(R.id.btnActivity5);
        btnActivity5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity5);
            }
        });
        final ImageButton btnActivity6 = findViewById(R.id.btnActivity6);
        btnActivity6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressButton(btnActivity6);
            }
        });

        lytStart = findViewById(R.id.lytStart);
        lytEmotion = findViewById(R.id.lytChooseEmotion);
        lytActivity = findViewById(R.id.lytChooseActivity);
        lytDone = findViewById(R.id.lytDone);
        lytCounting = findViewById(R.id.lytCount);
        btnDone = findViewById(R.id.btnGoBack);
        btnAgain = findViewById(R.id.btnAgain);

    }

    void pressButton(ImageButton btn) {

        if (btn.getContentDescription() == getResources().getString(R.string.Drawing)) {
            Intent intent = new Intent(MainActivity.this, Paint.class);
            startActivity(intent);
        } else if (btn.getContentDescription() == getResources().getString(R.string.Counting)) {
            lytActivity.setVisibility(View.GONE);
            lytCounting.setVisibility(View.VISIBLE);
            lytDone.setVisibility(View.VISIBLE);
            btnAgain.setEnabled(false);
            btnAgain.setVisibility(View.INVISIBLE);

            //Counting();
        }
    }

    /*
    void Counting() {
        TextView Number = findViewById(R.id.lblNumber);
        while (Number.getText().toString() != "10") {
            Number.setText(Integer.parseInt(Number.getText().toString()) + 1);
            Log.d("Number",Number.getText().toString());
        }
    }
    */

}

