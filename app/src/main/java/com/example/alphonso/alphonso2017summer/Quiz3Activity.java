package com.example.alphonso.alphonso2017summer;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.alphonso.alphonso2017summer.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Quiz3Activity  extends BaseActivity implements  View.OnTouchListener{
    private GestureDetector gestureDetector1;
    private int sumX=0;
    private int sumY=0;

    @BindView(R.id.activity_quiz5_gesture_tv)
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        ButterKnife.bind(this);
        gestureDetector1 = new GestureDetector(this, new Quiz3Activity.simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Click");
            }
        });

    }
    public void right(View view) {
        TranslateAnimation animate = new TranslateAnimation(-500, view.getWidth(), 0, 0);
        animate.setDuration(2000);
        animate.setFillAfter(true);
        view.startAnimation(animate);

    }
    public void left(View view){
        TranslateAnimation animate = new TranslateAnimation(0,-view.getWidth(),0,0);
        animate.setDuration(2000);
        animate.setFillAfter(true);
        view.startAnimation(animate);

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        return gestureDetector1.onTouchEvent(event);
//        return false;
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapUp");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.d("Gesture","onLongPress");

            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");

            sumX+=distanceX;

            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");

                if(Math.abs(sumX)>200){
                    showToast("Left to right");
                    right(tv);
                }
                else{
                    showToast("Right to left");
                   left(tv);
                }


            return super.onFling(e1, e2, velocityX, velocityY);
        }

    }

}