package com.wxy.selfview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final touchView touview = new touchView(this);
        FrameLayout frameLayout  = findViewById(R.id.myframeLayout);
        touview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touview.touchX = event.getX();
                touview.touchY = event.getY();
                touview.invalidate();
                return false;
            }
        });
        touview.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_HOVER_ENTER:
                        Log.d("wuxiangyu","ACTION_HOVER_ENTER");
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        Log.d("wuxiangyu","ACTION_HOVER_EXIT");
                        break;
                    case  MotionEvent.ACTION_HOVER_MOVE:
                        float x = event.getX();
                        float y =event.getY();
                        Log.d("wuxiangyu","m x =" + x + "  y = "+ y);
                        break;
                }
                return false;
            }
        });
        frameLayout.addView(touview);
    }
}