package com.div.sortappjava.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import com.div.sortappjava.R;
import com.div.sortappjava.datagenerator.datagenerators.IntegerDataGeneratorSingleton;
import com.div.sortappjava.ui.SortObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arioch666 on 11/14/17.
 *
 * Looked at
 * https://github.com/naman14/AlgorithmVisualizer-Android/blob/master/app/src/main/java/com/naman14/algovisualizer/visualizer/AlgorithmVisualizer.java
 * for how to do the visualization
 *
 * At this point I am coding with the goal of finishing the app. Throwing most of the conventions out the window. if time permits i will
 * refactor.
 *
 */

public class SortObjectVisualizer extends View {
    Paint paint;
    Paint highlightPaintSwap;
    Paint highlightPaintDone;
    Paint highlightRangePaint;

    SortObject sortObject;
    int max;
    private int strokeWidth;
    private Set<Integer> blankHashSet;

    public SortObjectVisualizer(Context context) {
        super(context);
        initialize();
    }

    public void setSortObject(SortObject sortObject) {
        this.sortObject = sortObject;
        max = sortObject.getMaxValue();
        invalidate();
    }

    public SortObjectVisualizer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize() {
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_blue_light));

        highlightPaintDone = new Paint();
        highlightPaintDone.setColor(getResources().getColor(R.color.buttonGreen));

        highlightPaintSwap = new Paint();
        highlightPaintSwap.setColor(getResources().getColor(R.color.colorPrimary));

        blankHashSet = new HashSet<>();
    }

    private void calculatestrokeWidth() {
        assert (sortObject.getValues().getValue()) != null;

        int size = ((Integer[])sortObject.getValues().getValue()).length;

        strokeWidth = (getWidth()/size);

        paint.setStrokeWidth(strokeWidth);
//        highlightRangePaint.setStrokeWidth(strokeWidth);
        highlightPaintDone.setStrokeWidth(strokeWidth);
        highlightPaintSwap.setStrokeWidth(strokeWidth);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        calculatestrokeWidth();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sortObject.getValues() != null
                && sortObject.getValues().getValue() != null) {
            Integer[] integers = (Integer[]) sortObject.getValues().getValue();
            int length = integers.length;

            float xPosition = 0;

            Set<Integer> highlightIndices = (Set<Integer>) sortObject.getHighlightIndices().getValue();

            for (int i = 0; i < length; i++) {
                if ((Boolean)sortObject.getSorted().getValue()) {
                    canvas.drawLine(xPosition, getHeight() - ((integers[i]/(float)max) * getHeight()),
                            xPosition, getHeight(), highlightPaintDone);
                }
                if (highlightIndices != null
                        && highlightIndices.contains(i)) {
                        canvas.drawLine(xPosition, getHeight() - ((integers[i]/(float)max) * getHeight()),
                                xPosition, getHeight(), highlightPaintSwap);
                } else {
                    canvas.drawLine(xPosition, getHeight() - ((integers[i]/(float)max) * getHeight()),
                            xPosition, getHeight(), paint);
                }

                xPosition+=strokeWidth;
            }

            sortObject.setHighlightIndices(blankHashSet);
        }
    }
}
