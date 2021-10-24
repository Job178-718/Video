package com.example.video.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

/**
 * @author BoSun
 * @date 2021/10/20 21:51
 */
public class SearchSun extends View {

    public SearchSun(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //setMeasuredDimension(measuredWidth(), int measuredHeight);
    }
    
    private int measurewidth(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode==MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 200;
            if(specMode==MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
    
    
}
