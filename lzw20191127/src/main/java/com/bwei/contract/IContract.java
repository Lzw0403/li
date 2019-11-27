package com.bwei.contract;

import com.bwei.bean.MyBean;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:01
 *@Description:${DESCRIPTION}
 **/public interface IContract {
    interface CallBack{
        void success(String jsonStr);
        void error(String err);
    }
    interface IPresenter{
        void success(String json);
    }
    interface IView{
        void success(MyBean myBean);
    }
}
