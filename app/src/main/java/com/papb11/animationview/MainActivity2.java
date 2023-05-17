package com.papb11.animationview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView image = findViewById(R.id.theImage);
        Button startBtn = findViewById(R.id.btnStart);

        animator = ObjectAnimator.ofFloat(image, "rotation", 360);

        startBtn.setOnClickListener(view -> {
            animator.setDuration(1000);
            animator.start();
        });
    }
}