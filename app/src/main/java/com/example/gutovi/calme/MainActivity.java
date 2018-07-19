package com.example.gutovi.calme;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
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
    LinearLayout lytConfirm;
    LinearLayout lytActivity;
    LinearLayout lytDone;
    LinearLayout lytCounting;
    Button btnGoBack;
    Button btnDone;
    Button btnAgain;
    TextView lblEmotionTitle;

    LinearLayout lytImEmRow1;
    LinearLayout lytImEmRow2;
    LinearLayout lytImEmRow3;
    LinearLayout lytNaEmRow1;
    LinearLayout lytNaEmRow2;
    LinearLayout lytNaEmRow3;

    ImageButton btnEmotion1;
    TextView lblEmotion1;
    ImageButton btnEmotion2;
    TextView lblEmotion2;
    ImageButton btnEmotion3;
    TextView lblEmotion3;
    ImageButton btnEmotion4;
    TextView lblEmotion4;
    ImageButton btnEmotion5;
    TextView lblEmotion5;
    ImageButton btnEmotion6;
    TextView lblEmotion6;

    ImageButton btnYes;
    ImageButton btnNo;
    AnimatedVectorDrawableCompat avdcYes;
    AnimatedVectorDrawableCompat avdcNo;

    TextView Number;
    TextView NumberName;

    CountDownTimer NumberCounter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        avdcYes = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_yes);
        avdcNo = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_no);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        btnYes.setImageDrawable(avdcYes);
        btnNo.setImageDrawable(avdcNo);


        lytStart = findViewById(R.id.lytStart);
        lytEmotion = findViewById(R.id.lytChooseEmotion);
        lytConfirm = findViewById(R.id.lytConfirm);
        lytActivity = findViewById(R.id.lytChooseActivity);
        lytDone = findViewById(R.id.lytDone);
        lytCounting = findViewById(R.id.lytCount);
        btnGoBack = findViewById(R.id.btnGoBack);
        btnDone = findViewById(R.id.btnDone);
        btnAgain = findViewById(R.id.btnAgain);
        lblEmotionTitle = findViewById(R.id.lblHowFeeling);

        lytImEmRow1 = findViewById(R.id.lytEmotionImageRow1);
        lytImEmRow2 = findViewById(R.id.lytEmotionImageRow2);
        lytImEmRow3 = findViewById(R.id.lytEmotionImageRow3);
        lytNaEmRow1 = findViewById(R.id.lytEmotionNameRow1);
        lytNaEmRow2 = findViewById(R.id.lytEmotionNameRow2);
        lytNaEmRow3 = findViewById(R.id.lytEmotionNameRow3);

        btnEmotion1 = findViewById(R.id.btnEmotion1);
        lblEmotion1 = findViewById(R.id.lblEmotion1);
        btnEmotion2 = findViewById(R.id.btnEmotion2);
        lblEmotion2 = findViewById(R.id.lblEmotion2);
        btnEmotion3 = findViewById(R.id.btnEmotion3);
        lblEmotion3 = findViewById(R.id.lblEmotion3);
        btnEmotion4 = findViewById(R.id.btnEmotion4);
        lblEmotion4 = findViewById(R.id.lblEmotion4);
        btnEmotion5 = findViewById(R.id.btnEmotion5);
        lblEmotion5 = findViewById(R.id.lblEmotion5);
        btnEmotion6 = findViewById(R.id.btnEmotion6);
        lblEmotion6 = findViewById(R.id.lblEmotion6);


        Number = findViewById(R.id.lblNumber);
        NumberName = findViewById(R.id.lblNumberName);

        NumberCounter = new CountDownTimer(15000, 1500) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 13500) {
                    Number.setText(Long.toString(9 - millisUntilFinished / 1500));
                    if (millisUntilFinished > 12000) {
                        NumberName.setText(R.string.one);
                    } else if (millisUntilFinished > 10500) {
                        NumberName.setText(R.string.two);
                    } else if (millisUntilFinished > 9000) {
                        NumberName.setText(R.string.three);
                    } else if (millisUntilFinished > 7500) {
                        NumberName.setText(R.string.four);
                    } else if (millisUntilFinished > 6000) {
                        NumberName.setText(R.string.five);
                    } else if (millisUntilFinished > 4500) {
                        NumberName.setText(R.string.six);
                    } else if (millisUntilFinished > 3000) {
                        NumberName.setText(R.string.seven);
                    } else if (millisUntilFinished > 1500) {
                        NumberName.setText(R.string.eight);
                    } else if (millisUntilFinished > 0) {
                        NumberName.setText(R.string.nine);
                    }
                }
            }

            public void onFinish() {
                Number.setText("10");
                NumberName.setText(R.string.ten);
                btnAgain.setEnabled(true);
                btnAgain.setVisibility(View.VISIBLE);
                btnDone.setEnabled(true);
                btnDone.setVisibility(View.VISIBLE);
            }
        };

        final ImageButton btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lytStart.setVisibility(View.GONE);
                lytEmotion.setVisibility(View.VISIBLE);
            }
        });


        btnEmotion1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion1, lblEmotion1, lytImEmRow1, lytNaEmRow1);
            }
        });
        btnEmotion2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion2, lblEmotion2, lytImEmRow1, lytNaEmRow1);
            }
        });
        btnEmotion3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion3, lblEmotion3, lytImEmRow2, lytNaEmRow2);
            }
        });
        btnEmotion4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion4, lblEmotion4, lytImEmRow2, lytNaEmRow2);
            }
        });
        btnEmotion5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion5, lblEmotion5, lytImEmRow3, lytNaEmRow3);
            }
        });
        btnEmotion6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressEmotionButton(btnEmotion6, lblEmotion6, lytImEmRow3, lytNaEmRow3);
            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnEmotion1.setVisibility(View.VISIBLE);
                lblEmotion1.setVisibility(View.VISIBLE);
                lblEmotion1.setText(R.string.calm);
                lblEmotion1.setTextSize(24);
                btnEmotion2.setVisibility(View.VISIBLE);
                lblEmotion2.setVisibility(View.VISIBLE);
                lblEmotion2.setText(R.string.sad);
                lblEmotion2.setTextSize(24);
                btnEmotion3.setVisibility(View.VISIBLE);
                lblEmotion3.setVisibility(View.VISIBLE);
                lblEmotion3.setText(R.string.mad);
                lblEmotion3.setTextSize(24);
                btnEmotion4.setVisibility(View.VISIBLE);
                lblEmotion4.setVisibility(View.VISIBLE);
                lblEmotion4.setText(R.string.scared);
                lblEmotion4.setTextSize(24);
                btnEmotion5.setVisibility(View.VISIBLE);
                lblEmotion5.setVisibility(View.VISIBLE);
                lblEmotion5.setText(R.string.frustrated);
                lblEmotion5.setTextSize(24);
                btnEmotion6.setVisibility(View.VISIBLE);
                lblEmotion6.setVisibility(View.VISIBLE);
                lblEmotion6.setText(R.string.anxious);
                lblEmotion6.setTextSize(24);
                lytNaEmRow1.setVisibility(View.VISIBLE);
                lytNaEmRow2.setVisibility(View.VISIBLE);
                lytNaEmRow3.setVisibility(View.VISIBLE);
                lytImEmRow1.setVisibility(View.VISIBLE);
                lytImEmRow2.setVisibility(View.VISIBLE);
                lytImEmRow3.setVisibility(View.VISIBLE);

                lytConfirm.setVisibility(View.GONE);

                lblEmotionTitle.setText(R.string.FeelingQuestion);

                avdcYes.stop();
                avdcNo.stop();
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lytEmotion.setVisibility(View.GONE);
                lytActivity.setVisibility(View.VISIBLE);
                lytConfirm.setVisibility(View.GONE);
            }
        });

        final ImageButton btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity1.getContentDescription().toString());
            }
        });
        final ImageButton btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity2.getContentDescription().toString());
            }
        });
        final ImageButton btnActivity3 = findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity3.getContentDescription().toString());
            }
        });
        final ImageButton btnActivity4 = findViewById(R.id.btnActivity4);
        btnActivity4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity4.getContentDescription().toString());
            }
        });
        final ImageButton btnActivity5 = findViewById(R.id.btnActivity5);
        btnActivity5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity5.getContentDescription().toString());
            }
        });
        final ImageButton btnActivity6 = findViewById(R.id.btnActivity6);
        btnActivity6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pressActivityButton(btnActivity6.getContentDescription().toString());
            }
        });

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lytActivity.setVisibility(View.VISIBLE);
                lytCounting.setVisibility(View.GONE);
                Number.setText("0");
                NumberName.setText(R.string.zero);
                NumberCounter.cancel();
                lytDone.setVisibility(View.GONE);
                btnAgain.setEnabled(false);
                btnAgain.setVisibility(View.INVISIBLE);
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((lytCounting.getVisibility() == View.VISIBLE))
                    pressActivityButton(getResources().getString(R.string.Counting));
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lytStart.setVisibility(View.VISIBLE);
                lytConfirm.setVisibility(View.GONE);
                lytActivity.setVisibility(View.GONE);
                lytEmotion.setVisibility(View.GONE);
                lytCounting.setVisibility(View.GONE);
                lytDone.setVisibility(View.GONE);
                btnNo.performClick();
            }
        });
    }

    void pressEmotionButton(ImageButton btn,TextView lbl, LinearLayout rowIm,LinearLayout rowNa) {
        if (lytConfirm.getVisibility() != View.VISIBLE) {
            btnEmotion1.setVisibility(View.GONE);
            lblEmotion1.setVisibility(View.GONE);
            btnEmotion2.setVisibility(View.GONE);
            lblEmotion2.setVisibility(View.GONE);
            btnEmotion3.setVisibility(View.GONE);
            lblEmotion3.setVisibility(View.GONE);
            btnEmotion4.setVisibility(View.GONE);
            lblEmotion4.setVisibility(View.GONE);
            btnEmotion5.setVisibility(View.GONE);
            lblEmotion5.setVisibility(View.GONE);
            btnEmotion6.setVisibility(View.GONE);
            lblEmotion6.setVisibility(View.GONE);
            lytNaEmRow1.setVisibility(View.GONE);
            lytNaEmRow2.setVisibility(View.GONE);
            lytNaEmRow3.setVisibility(View.GONE);
            lytImEmRow1.setVisibility(View.GONE);
            lytImEmRow2.setVisibility(View.GONE);
            lytImEmRow3.setVisibility(View.GONE);

            btn.setVisibility(View.VISIBLE);
            lbl.setVisibility(View.VISIBLE);
            rowIm.setVisibility(View.VISIBLE);
            rowNa.setVisibility(View.VISIBLE);

            lytConfirm.setVisibility(View.VISIBLE);

            lblEmotionTitle.setText(R.string.FeelingConfirmation);
            lbl.append("?");
            lbl.setTextSize(45);

            avdcYes.start();
            avdcYes.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    avdcYes.start();
                }
            });
            avdcNo.start();
            avdcNo.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    avdcNo.start();
                }
            });
        }
    }

    void pressActivityButton(String btn) {

        if (btn.equals(getResources().getString(R.string.Drawing))) {
            Intent intent = new Intent(MainActivity.this, Paint.class);
            startActivity(intent);
        } else if (btn.equals(getResources().getString(R.string.Counting))) {
            Counting();
        }
    }


    void Counting() {
        lytActivity.setVisibility(View.GONE);
        lytCounting.setVisibility(View.VISIBLE);
        Number.setText("0");
        NumberName.setText(R.string.zero);
        lytDone.setVisibility(View.VISIBLE);
        btnAgain.setEnabled(false);
        btnAgain.setVisibility(View.INVISIBLE);
        btnDone.setEnabled(false);
        btnDone.setVisibility(View.INVISIBLE);

        NumberCounter.start();
    }


}

