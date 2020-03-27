//John Semaan 3/27/20
//Issues: could not find why third image was not changing.
//points were not aknowledging third image.
//delay in opening the point/rules page
package com.example.slotmachine;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private Drawable ch;
    private Drawable pe;
    private Drawable gr;
    private Button start;
    private Button rulepage;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private TextView score;
    public boolean go;
    public int points;
    private UpdateImage upim;
    public Handler handler;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch = getDrawable(R.drawable.cherry);
        gr = getDrawable(R.drawable.grape);
        pe = getDrawable(R.drawable.pear);
        start = findViewById(R.id.Start);
        rulepage = findViewById(R.id.Rules);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        score = findViewById(R.id.Score);
        points = 0;
        score.setText("Points: " + points);
        go = false;
        upim = new UpdateImage();
        handler = new Handler();

        image1.setImageDrawable(ch);
        image2.setImageDrawable(pe);
        image3.setImageDrawable(gr);
    }

    public void StartPressed(View v) {
        if (go) {
            go = false; /*if the start button is already running the slots it'll pause and check requirements*/
            handler.removeCallbacks(upim);
            if (image1.getDrawable() == image2.getDrawable()) {
                points += 10;
                score.setText("Points: "+points);
            } else if (image2.getDrawable() == image3.getDrawable()) {
                points += 10;
                score.setText("Points: "+points);
            } else if (image1.getDrawable() == image3.getDrawable()) {
                points += 10;
                score.setText("Points: "+points);
            } else if (image1.getDrawable() == image2.getDrawable() &&  image2.getDrawable() == image3.getDrawable()) {
                points += 50;
                score.setText("Points: "+points);
            } else if (image1.getDrawable()==(ch) || image2.getDrawable()==(ch) || image3.getDrawable()==(ch)) {
                points += 5;
                score.setText("Points: "+points);
            }
        } else {
            go = true;
            //creates handler starts counter
            handler.postDelayed(upim, 200);
        }
    }

    /* rules as follows:
     if two of images are the same you will be rewarded with 10 points
     if three of the images are the same you will be rewarded with 50 points
     if you get a cherry by itself you will be rewarded with 5 points
     everything else will not bring up the score
     */
    public void RulesPressed(View v) {
        rulepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Rules.class));
            }
        });
    }

    public class UpdateImage implements Runnable {

        @Override
        public void run() {
            if (image1.getDrawable() ==ch) {
                image1.setImageDrawable(gr);
            } else if (image1.getDrawable() == gr) {
                image1.setImageDrawable(pe);
            } else {
                image1.setImageDrawable(ch);
            }
            if (image2.getDrawable()== ch) {
                image2.setImageDrawable(pe);
            } else if (image2.getDrawable()==pe) {
                image2.setImageDrawable(gr);
            } else {
                image2.setImageDrawable(ch);
            }
            if (image3.getDrawable()==gr) {
                image3.equals(ch);
            } else if (image3.getDrawable()==ch) {
                image3.equals(pe);
            } else {
                image3.equals(gr);
            }
            handler.postDelayed(upim,200);
        }
    }
}