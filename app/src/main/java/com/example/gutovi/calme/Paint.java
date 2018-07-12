package com.example.gutovi.calme;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.graphics.CanvasView;

public class Paint extends AppCompatActivity {

    private CanvasView canvas = null;

    boolean isPenColor = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        this.canvas = (CanvasView) this.findViewById(R.id.canvas);

        //this.canvas.setDrawer(CanvasView.Drawer.PEN);
        this.canvas.setPaintStrokeWidth(10F);
        this.canvas.setOpacity(255);

        Button btnUndo = findViewById(R.id.btnUndo);
        btnUndo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Undo();
            }
        });

        Button btnRedo = findViewById(R.id.btnRedo);
        btnRedo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Redo();
            }
        });

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Clear();
            }
        });

        Button btnBackPen = findViewById(R.id.btnBack_Pen);
        btnBackPen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isPenColor = !isPenColor;
            }
        });

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save();
            }
        });

        Button btnBlack = findViewById(R.id.btnBlack);
        btnBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Black();
            }
        });

        Button btnGray = findViewById(R.id.btnGray);
        btnGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Gray();
            }
        });

        Button btnWhite = findViewById(R.id.btnWhite);
        btnWhite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                White();
            }
        });

        Button btnRed = findViewById(R.id.btnRed);
        btnRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Red();
            }
        });

        Button btnOrange = findViewById(R.id.btnOrange);
        btnOrange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Orange();
            }
        });

        Button btnYellow = findViewById(R.id.btnYellow);
        btnYellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Yellow();
            }
        });

        Button btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Green();
            }
        });

        Button btnCyan = findViewById(R.id.btnBlue);
        btnCyan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Cyan();
            }
        });

        Button btnBlue = findViewById(R.id.btnIndigo);
        btnBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Blue();
            }
        });

        Button btnViolet = findViewById(R.id.btnViolet);
        btnViolet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Purple();
            }
        });

        Button btnPink = findViewById(R.id.btnPink);
        btnPink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Pink();
            }
        });
    }





    void Undo(){
        if(this.canvas.canUndo()) this.canvas.undo();
    }
    void Redo(){
        if(this.canvas.canRedo()) this.canvas.redo();
    }
    void Clear(){
        this.canvas.clearTovi(this.canvas.getBaseColor(),this.canvas.getWidth(),this.canvas.getHeight());
    }
    void Save(){
        Bitmap bitmap = this.canvas.getBitmap();
    }


    void Black(){
        if (isPenColor) this.canvas.setPaintStrokeColor(Color.BLACK);
        else            this.canvas.setBaseColor(Color.BLACK);
    }
    void Gray(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintGray));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintGray));
    }
    void White(){
        if (isPenColor) this.canvas.setPaintStrokeColor(Color.WHITE);
        else            this.canvas.setBaseColor(Color.WHITE);
    }
    void Red(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintRed));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintRed));
    }
    void Orange(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintOrange));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintOrange));
    }
    void Yellow(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintYellow));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintYellow));
    }
    void Green(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintGreen));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintGreen));
    }
    void Cyan(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintCyan));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintCyan));
    }
    void Blue(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintBlue));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintBlue));
    }
    void Purple(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintPurple));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintPurple));
    }
    void Pink(){
        if (isPenColor) this.canvas.setPaintStrokeColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintPink));
        else            this.canvas.setBaseColor(ContextCompat.getColor(getApplicationContext(), R.color.PaintPink));
    }
}