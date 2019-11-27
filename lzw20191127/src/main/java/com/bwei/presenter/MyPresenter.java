package com.bwei.presenter;

import com.bwei.base.BasePresenter;
import com.bwei.bean.MyBean;
import com.bwei.contract.IContract;
import com.bwei.lzw20191127.MainActivity;
import com.bwei.model.MyModel;
import com.google.gson.Gson;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:12
 *@Description:${DESCRIPTION}
 **/public class MyPresenter extends BasePresenter implements IContract.IPresenter {
    MyModel myModel;

    public MyPresenter() {
        myModel = new MyModel();
    }

    @Override
    public void success(String json) {
        myModel.getTe(json, new IContract.CallBack() {
            @Override
            public void success(String jsonStr) {
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(jsonStr, MyBean.class);
                MainActivity mainActivity = (MainActivity) v;
                mainActivity.success(myBean);
            }

            @Override
            public void error(String err) {

            }
        });
    }
}
