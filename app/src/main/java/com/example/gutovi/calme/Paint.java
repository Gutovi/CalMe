package com.example.gutovi.calme;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.util.Log;

import com.android.graphics.CanvasView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Paint extends AppCompatActivity {

    private CanvasView canvas = null;

    boolean isPenColor = true;

    Button btnBackPen;
    ImageView imgBackPen;

    int BGColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        canvas = this.findViewById(R.id.canvas);

        //this.canvas.setDrawer(CanvasView.Drawer.PEN);
        canvas.setPaintStrokeWidth(15F);
        canvas.setOpacity(255);
        canvas.setLineCap(android.graphics.Paint.Cap.ROUND);

        imgBackPen = findViewById(R.id.imgBack_Pen);

        BGColor = getResources().getColor(R.color.colorPrimaryDark);

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

        btnBackPen = findViewById(R.id.btnBack_Pen);
        btnBackPen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BackPenSwitch();
            }
        });
        imgBackPen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BackPenSwitch();
            }
        });

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save();
            }
        });

        final Button btnBlack = findViewById(R.id.btnBlack);
        btnBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnBlack);
            }
        });

        final Button btnGray = findViewById(R.id.btnGray);
        btnGray.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnGray);
            }
        });

        final Button btnWhite = findViewById(R.id.btnWhite);
        btnWhite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnWhite);
            }
        });

        final Button btnRed = findViewById(R.id.btnRed);
        btnRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnRed);
            }
        });

        final Button btnOrange = findViewById(R.id.btnOrange);
        btnOrange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnOrange);
            }
        });

        final Button btnYellow = findViewById(R.id.btnYellow);
        btnYellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnYellow);
            }
        });

        final Button btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnGreen);
            }
        });

        final Button btnCyan = findViewById(R.id.btnBlue);
        btnCyan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnCyan);
            }
        });

        final Button btnBlue = findViewById(R.id.btnIndigo);
        btnBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnBlue);
            }
        });

        final Button btnViolet = findViewById(R.id.btnViolet);
        btnViolet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnViolet);
            }
        });

        final Button btnPink = findViewById(R.id.btnPink);
        btnPink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnPink);
            }
        });

        final Button btnBrown = findViewById(R.id.btnBrown);
        btnBrown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorChange(btnBrown);
            }
        });
    }


    void BackPenSwitch(){
        isPenColor = !isPenColor;
        if (isPenColor){
            imgBackPen.setImageResource(android.R.drawable.ic_menu_edit);
            imgBackPen.setImageTintList(ColorStateList.valueOf(canvas.getPaintStrokeColor()));
            imgBackPen.setContentDescription(getString(R.string.namePenColor));
            canvas.setOpacity(255);
            canvas.setPaintStrokeWidth(15F);
            btnBackPen.setTextColor(BGColor);
            btnBackPen.setBackgroundColor(Color.WHITE);
        } else{
            imgBackPen.setImageResource(android.R.drawable.ic_menu_set_as);
            imgBackPen.setImageTintList(ColorStateList.valueOf(canvas.getBaseColor()));
            imgBackPen.setContentDescription(getString(R.string.nameBackgroundColor));
            canvas.setOpacity(0);
            canvas.setPaintStrokeWidth(0F);
            btnBackPen.setTextColor(Color.WHITE);
            btnBackPen.setBackgroundColor(BGColor);

        }
    }

    void Undo(){
        if(this.canvas.canUndo()) this.canvas.undo();
    }
    void Redo(){
        if(this.canvas.canRedo()) this.canvas.redo();
    }
    void Clear(){
        while (this.canvas.canUndo()) this.canvas.undo();
        //this.canvas.clearTovi(this.canvas.getBaseColor(),this.canvas.getWidth(),this.canvas.getHeight());
    }
    void Save() {
        if(isExternalStorageWritable()) {
            Bitmap bitmap = this.canvas.getBitmap();

            File Dir = getPublicAlbumStorageDir(getString(R.string.app_name));
            Dir.mkdirs();
            int n = 1;
            String photoName = getString(R.string.wordDrawing) + " " + n + ".png";
            File file = new File(Dir, photoName);
            if (file.exists()) {
                while (file.exists()) {
                    n++;
                    photoName = getString(R.string.wordDrawing) + " " + n + ".png";
                    file = new File(Dir, photoName);
                }
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                    Toast.makeText(getApplicationContext(), getString(R.string.saved), Toast.LENGTH_SHORT).show();

                } catch (Exception ignored) {
                }
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                Toast.makeText(getApplicationContext(), getString(R.string.trySaveAgain), Toast.LENGTH_LONG).show();
            }
        }
        else Toast.makeText(getApplicationContext(), getString(R.string.notSaved), Toast.LENGTH_LONG).show();

    }


    void colorChange(Button btnTouched){
        ColorDrawable TempColor = (ColorDrawable) btnTouched.getBackground();
        if (isPenColor) {
            this.canvas.setPaintStrokeColor(TempColor.getColor());
            imgBackPen.setImageTintList(ColorStateList.valueOf(canvas.getPaintStrokeColor()));
        } else {
            this.canvas.setBaseColor(TempColor.getColor());
            imgBackPen.setImageTintList(ColorStateList.valueOf(canvas.getBaseColor()));
        }

    }



    public File getPublicAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("", "Directory not created");
        }
        return file;
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}