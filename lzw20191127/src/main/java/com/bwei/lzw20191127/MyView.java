package com.bwei.lzw20191127;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:10:04
 *@Description:${DESCRIPTION}
 **/public class MyView extends LinearLayout {
    public EditText ed_one;
    private Button bu_one;
    private oncall call;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.myview_layout,this);
        ed_one = findViewById(R.id.ed_one);
        bu_one = findViewById(R.id.bu_one);
        bu_one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                call.onclick();
            }
        });
    }
    public void setCall(oncall call){
        this.call = call;
    }
    public interface oncall{
        void onclick();
    }
}
