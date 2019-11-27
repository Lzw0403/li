package com.bwei.api;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:14
 *@Description:${DESCRIPTION}
 **/public class MyApi {
    public static String url(String keyw){
        return "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+keyw+"&page=1&count=5";
    }
}
