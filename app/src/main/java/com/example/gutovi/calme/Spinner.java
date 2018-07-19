package com.example.gutovi.calme;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Spinner extends AppCompatActivity implements GestureDetector.OnGestureListener {


    private GestureDetectorCompat mDetector;

    ImageView Spinner;
    float lastAngle = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);

        Spinner = findViewById(R.id.imgSpinner);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,float velocityX, float velocityY) {
        Log.d("X", "X velocity: " + velocityX);
        Log.d("Y", "Y velocity: " + velocityY);


        float angle = velocityX;
        float pivotX = Spinner.getWidth() / 2;
        float pivotY = Spinner.getHeight() / 2;

        final Animation animRotate = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY);
        lastAngle = angle;
        animRotate.setDuration(Math.abs(Math.round(velocityX)));
        animRotate.setFillAfter(true);

        Spinner.startAnimation(animRotate);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }


    /*private VelocityTracker mVelocityTracker = null;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);
        float xVel;
        float yVel;
        if(action == MotionEvent.ACTION_MOVE){

            if(mVelocityTracker == null) {
                // Retrieve a new VelocityTracker object to watch the
                // velocity of a motion.
                mVelocityTracker = VelocityTracker.obtain();
            }
            else {
                // Reset the velocity tracker back to its initial state.
                mVelocityTracker.clear();
            }
                mVelocityTracker.addMovement(event);
                // When you want to determine the velocity, call
                // computeCurrentVelocity(). Then call getXVelocity()
                // and getYVelocity() to retrieve the velocity for each pointer ID.
                mVelocityTracker.computeCurrentVelocity(1000);
                // Log velocity of pixels per second
                // Best practice to use VelocityTrackerCompat where possible.
                xVel = mVelocityTracker.getXVelocity(pointerId);
                yVel = mVelocityTracker.getYVelocity(pointerId);


                Log.d("", "X velocity: " + xVel);

                Log.d("", "Y velocity: " + yVel);
        }
        return true;
    }*/
}
