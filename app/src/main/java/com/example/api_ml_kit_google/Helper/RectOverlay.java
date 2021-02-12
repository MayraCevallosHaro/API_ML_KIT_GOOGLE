package com.example.api_ml_kit_google.Helper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class RectOverlay extends GraphicOverlay.Graphic {
    private int mRectColor = Color.GREEN;
    private float mStrokeWidth = 4.0f;
    private Paint mRectPaint;
    private GraphicOverlay graphicOverlay;
    private Rect rect;

    public RectOverlay( GraphicOverlay graphicOverlay, Rect rect)
    {
        super(graphicOverlay);
        mRectPaint = new Paint();
        mRectColor.setColor(mRectColor);
        mRectColor.setStyle(Paint.Style.STROKE);
        mRectColor.setStokeWidth(mStrokeWidth);

        this.graphicOverlay = graphicOverlay;
        this.rect = rect;

        postInvalidate();
    }
    @Overrride
    public void draw(Canvas canvas)
    {
        RectF rectF = new RectF(react);
        rectF.left = translateX(rectF.left);
        rectF.right = translateX(rectF.right);
        rectF.top = translateX(rectF.top);
        rectF.bottom = translateX(rectF.bottom);

        canvas.drawRect(rectF, mRectPaint);
    }
}
