package com.papb11.animationview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class PulseAnimation extends View {
    private float theRadius;
    private final Paint thePaint = new Paint();
    private static final int COLOR_ADJUSTER = 5;

    private float mX;
    private float mY;

    private static final int ANIMATION_DURATION = 4000;
    private static final long ANIMATION_DELAY = 1000;
    private AnimatorSet animatorSet = new AnimatorSet();

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);

        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());
        growAnimator.setDuration(ANIMATION_DURATION);
        growAnimator.setInterpolator(new LinearInterpolator());

        ObjectAnimator shrinkAnimator = ObjectAnimator.ofFloat(this, "radius", getWidth(), 0);
        shrinkAnimator.setDuration(ANIMATION_DURATION);
        shrinkAnimator.setInterpolator(new LinearInterpolator());
        shrinkAnimator.setStartDelay(ANIMATION_DELAY);

        ObjectAnimator growAgain = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());
        growAgain.setDuration(ANIMATION_DURATION);
        growAgain.setInterpolator(new LinearInterpolator());
        growAgain.setStartDelay(ANIMATION_DELAY);

        animatorSet.play(growAnimator).before(shrinkAnimator);
//        animatorSet.play(shrinkAnimator).after(growAnimator).before(growAgain);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            mX = event.getX();
            mY = event.getY();

            if (animatorSet != null && animatorSet.isRunning()) {
                animatorSet.cancel();
            }
            animatorSet.start();
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mX, mY, theRadius, thePaint);
    }

    private void setRadius(float radius) {
        theRadius = radius;
        thePaint.setColor(Color.RED + (int) radius / COLOR_ADJUSTER);
        invalidate();
    }

    public PulseAnimation(Context context) {
        super(context);
    }

    public PulseAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
