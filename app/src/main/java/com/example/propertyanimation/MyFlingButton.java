package com.example.propertyanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;

import static androidx.dynamicanimation.animation.SpringForce.STIFFNESS_LOW;

public class MyFlingButton extends View {
    public MyFlingButton(Context context) {
        super(context);
    }

    public MyFlingButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFlingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //flingAnimacion2();
                springAnimacion2();
                break;
            default:
                // Do nothing.
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint myPaint = new Paint();
        myPaint.setColor(Color.rgb(0, 0, 0));
        myPaint.setStrokeWidth(10);
        canvas.drawRect(100, 100, 200, 200, myPaint);
    }

    public void flingAnimacion(){
        // Create an animation that rotates around the views X value.
        FlingAnimation fling = new FlingAnimation(
                this, DynamicAnimation.ROTATION_X);
        // Set parameters and constraints for the animation.
        // This does almost a full rotation, but not quite.
        // Play with these values!
        fling.setStartVelocity(150) // In pixels per second.
                .setFriction(0.11f) // Friction slows animation.
                .start();
    }
    public void flingAnimacion2(){
        FlingAnimation fling = new FlingAnimation(this,
                DynamicAnimation.ROTATION_X);
        fling.setStartVelocity(150)
                .setMinValue(0)
                .setMaxValue(1000)
                .setFriction(0.1f)
                .start();
    }
    public void springAnimacion(){
        // Create a spring animation along the view's Y position.
        // Let resting position be at the view's current Y position.
        final SpringAnimation anim = new SpringAnimation(this,
                (FloatPropertyCompat) DynamicAnimation.Y, this.getY())
                .setStartVelocity(10000); // In pixels per second.
        // Low stiffness makes the spring bouncy.
        anim.getSpring().setStiffness(STIFFNESS_LOW);
        anim.start();
    }
    public void springAnimacion2(){
        final SpringAnimation anim = new SpringAnimation(
                this, DynamicAnimation.Y, 10)
                .setStartVelocity(10000);
        anim.getSpring().setStiffness(STIFFNESS_LOW);
        anim.start();
    }
}
