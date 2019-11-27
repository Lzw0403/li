package com.bwei.base;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:8:54
 *@Description:${DESCRIPTION}
 **/public abstract class BasePresenter<V extends BaseActivity> {
    public V v;
    public void success(V v){
        this.v = v;
    }
    public void unsuccess(){
        if (v!=null){
            v = null;
        }
    }
}
