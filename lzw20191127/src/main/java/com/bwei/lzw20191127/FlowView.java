package com.bwei.lzw20191127;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:10:32
 *@Description:${DESCRIPTION}
 **/public class FlowView extends ViewGroup {
    private Context context;
    private int pixels;

    public FlowView(Context context) {
        super(context);
        this.context = context;
    }

    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public FlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public FlowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }
    public void inte(Context context){
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        pixels = displayMetrics.widthPixels;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = 0;
        int right = 0;
        int top = 0;
        int button = 0;
        int sprce = 0;
        for (int j = 0; j < childCount; j++) {
            View childAt = getChildAt(j);
            childAt.measure(0,0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            left = right + sprce;
            right = left + measuredWidth;
            if (right > pixels) {
                left = sprce;
                right = left + measuredWidth;
                top = button + sprce;
            }
            button = measuredHeight + top;
            //摆放子view
            childAt.layout(left, top, right, button);
        }
    }

    public void addTag(String tag) {
        final TextView textView = new TextView(context);
        textView.setText(tag);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setPadding(10, 10, 10, 10);
        textView.setBackgroundColor(Color.parseColor("#fff5ee"));
        addView(textView);
    }

}
