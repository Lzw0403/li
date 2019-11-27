package com.bwei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:8:54
 *@Description:${DESCRIPTION}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p = initPresenter();
        if (p!=null){
            p.success(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unsuccess();
            p=null;
        }
    }
}
