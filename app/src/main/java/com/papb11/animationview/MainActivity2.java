package com.papb11.animationview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView image = findViewById(R.id.theImage);
        Button startBtn = findViewById(R.id.btnStart);
        FloatingActionButton btnChange = findViewById(R.id.fab2);

        animator = ObjectAnimator.ofFloat(image, "rotation", 360);

        startBtn.setOnClickListener(view -> {
            animator.setDuration(1000);
            animator.start();
        });
        btnChange.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}