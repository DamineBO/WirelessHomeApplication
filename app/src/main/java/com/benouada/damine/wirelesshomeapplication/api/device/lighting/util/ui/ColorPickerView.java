package com.benouada.damine.wirelesshomeapplication.api.device.lighting.util.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// Color Picker View
public class ColorPickerView extends View {

    public static abstract interface OnColorChangedListener {
        public abstract void colorChanged(int color);
    }

    private static int CENTER_RADIUS = 0;
    private static int CENTER_X = 0;
    private static int CENTER_Y = 0;

    private final int[] mColors = {-65536, -65281, -16776961,
            -16711681, -16711936, -256, -65536};
    private boolean mHighlightCenter;

    private Paint mPaint;
    private Paint mCenterPaint;
    int color = Color.WHITE;

    private boolean mTrackingCenter;
    private int parentHeight, parentWidth;

    private OnColorChangedListener mListener;

    public void setOnColorChangedListener(OnColorChangedListener mListener) {
        this.mListener = mListener;
    }

    // constructor
    public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        draw();
    }

    // draw paint
    private void draw() {
        SweepGradient localSweepGradient = new SweepGradient(0.0F, 0.0F, mColors, null);
        mPaint = new Paint(1);
        mPaint.setShader(localSweepGradient);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(75.0F);
        mCenterPaint = new Paint(1);
        mCenterPaint.setStrokeWidth(5.0F);
    }

    public void setInitialColor(int color) {
        this.color = color;
        if (mPaint == null || mCenterPaint == null) {
            draw();
        }
        mCenterPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float f = CENTER_X - 0.5F * mPaint.getStrokeWidth();
        canvas.translate(CENTER_X, CENTER_X);
        canvas.drawOval(new RectF(-f, -f, f, f), mPaint);
        canvas.drawCircle(0.0F, 0.0F, CENTER_RADIUS, mCenterPaint);
        if (mTrackingCenter) {
            color = mCenterPaint.getColor();
            mCenterPaint.setStyle(Paint.Style.STROKE);
            if (mHighlightCenter)
                mCenterPaint.setAlpha(255);
            else
                mCenterPaint.setAlpha(128);
            canvas.drawCircle(0.0F, 0.0F,
                    CENTER_RADIUS + mCenterPaint.getStrokeWidth(),
                    mCenterPaint);
            mCenterPaint.setStyle(Paint.Style.FILL);
            mCenterPaint.setColor(color);
        }
    }

    @Override
    protected void onMeasure(int paramInt1, int paramInt2) {
        parentWidth = MeasureSpec.getSize(paramInt1);
        parentHeight = MeasureSpec.getSize(paramInt2);
        int i = Math.max(Math.min(parentWidth, parentHeight), 320);
        setMeasuredDimension(i, i);
        CENTER_X = i / 2;
        CENTER_Y = i / 2;
        CENTER_RADIUS = i / 6;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX() - CENTER_X;
        float y = event.getY() - CENTER_Y;
        boolean inCenter = Math.sqrt(x * x + y * y) <= CENTER_RADIUS;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mTrackingCenter = inCenter;
                if (inCenter) {
                    mHighlightCenter = true;
                    invalidate();
                    break;
                }
            case MotionEvent.ACTION_MOVE:
                if (mTrackingCenter) {
                    if (mHighlightCenter != inCenter) {
                        mHighlightCenter = inCenter;
                        invalidate();
                    }
                } else {
                    float f3 = (float) Math.atan2(y, x) / 6.283185F;
                    if (f3 < 0.0F) {
                        f3 += 1.0F;
                    }
                    mCenterPaint.setColor(interpColor(mColors, f3));
                    invalidate();
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mTrackingCenter) {
                    if (inCenter) {
                        if (mListener != null) {
                            mListener.colorChanged(mCenterPaint.getColor());
                        }
                    }
                    mTrackingCenter = false; // so we draw w/o halo
                    invalidate();
                }
                break;
        }
        return true;
    }

    private int ave(int paramInt1, int paramInt2, float paramFloat) {
        return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
    }

    private int interpColor(int colors[], float unit) {
        if (unit <= 0) {
            return colors[0];
        }
        if (unit >= 1) {
            return colors[colors.length - 1];
        }

        float p = unit * (colors.length - 1);
        int i = (int) p;
        p -= i;

        int c0 = colors[i];
        int c1 = colors[i + 1];
        int a = ave(Color.alpha(c0), Color.alpha(c1), p);
        int r = ave(Color.red(c0), Color.red(c1), p);
        int g = ave(Color.green(c0), Color.green(c1), p);
        int b = ave(Color.blue(c0), Color.blue(c1), p);

        return Color.argb(a, r, g, b);
    }
}