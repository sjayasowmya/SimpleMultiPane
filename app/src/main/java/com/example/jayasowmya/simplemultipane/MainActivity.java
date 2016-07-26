package com.example.jayasowmya.simplemultipane;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenOrientation = getResources().getConfiguration().orientation;
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            // Code to run whilst device is portrait goes here
            hideListPane();
            View descriptionPane = findViewById(R.id.description);
            descriptionPane.setOnTouchListener(new OnSwipeTouchListener(this) {
                @Override
                public void onSwipeLeft(){
                    hideListPane();
                    super.onSwipeLeft();
                }

                @Override
                public void onSwipeRight(){
                    showListPane();
                    super.onSwipeRight();
                }

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideListPane();
                    return super.onTouch(v, event);
                }
            });

        }


        }


    /**
     * Method to hide the list pane
     */
    private void hideListPane() {
        View listPane = findViewById(R.id.list);
        if (listPane.getVisibility() == View.VISIBLE) {
            listPane.setVisibility(View.GONE);
        }
    }

    /**
     * Method to show the list pane
     */
    private void showListPane() {
        View listPane = findViewById(R.id.list);
        if (listPane.getVisibility() == View.GONE) {
            listPane.setVisibility(View.VISIBLE);
        }
    }
}
