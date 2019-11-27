package com.bwei.model;

import com.bwei.contract.IContract;
import com.bwei.util.VolleyUtil;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:03
 *@Description:${DESCRIPTION}
 **/public class MyModel {
        public void getTe(String url, IContract.CallBack callBack){
            VolleyUtil.getInstance().toGet(url,callBack);
        }
}
