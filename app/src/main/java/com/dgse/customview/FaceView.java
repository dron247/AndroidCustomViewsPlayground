package com.dgse.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Objects;

/**
 * Created by Андрей on 22.03.2017.
 * http://startandroid.ru/ru/uroki/vse-uroki-spiskom.html
 */

public class FaceView extends View {

    private Context context;
    @ColorInt
    private int mBackgroundColor = Color.BLACK;
    @ColorInt
    private int mForegroundColor = Color.WHITE;

    private Paint mBackgroundPaint;
    private Paint mForegroundPaint;

    public FaceView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public FaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public FaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    public FaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, defStyleRes);
    }


    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.context = Objects.requireNonNull(context);

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(mBackgroundColor);

        mForegroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mForegroundPaint.setStyle(Paint.Style.STROKE);
        mForegroundPaint.setStrokeWidth(4f);
        mForegroundPaint.setColor(mForegroundColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
        int radius;
        if (viewWidthHalf > viewHeightHalf) {
            radius = viewHeightHalf;
        } else {
            radius = viewWidthHalf;
        }
        int strokeWidth = radius / 5;

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, mBackgroundPaint);
        canvas.drawCircle(viewWidthHalf - strokeWidth * 2, viewHeightHalf - strokeWidth, strokeWidth, mForegroundPaint);
        canvas.drawCircle(viewWidthHalf + strokeWidth * 2, viewHeightHalf - strokeWidth, strokeWidth, mForegroundPaint);
        /*RectF rectF = new RectF(
                viewWidthHalf - strokeWidth * 3,
                viewHeightHalf,
                viewWidthHalf + strokeWidth * 3,
                viewHeightHalf - strokeWidth * 3
        );
        canvas.drawArc(rectF, 0, 180, false, mForegroundPaint);*/
        canvas.drawLine(
                viewWidthHalf - strokeWidth * 2,
                viewHeightHalf + strokeWidth * 2,
                viewWidthHalf + strokeWidth * 2,
                viewHeightHalf + strokeWidth * 2,
                mForegroundPaint
        );
    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }*/
}
