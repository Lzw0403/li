package com.bwei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.app.MyApp;
import com.bwei.contract.IContract;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:03
 *@Description:${DESCRIPTION}
 **/public class VolleyUtil {
    //单例模式
    private static VolleyUtil volleyUtil;
    private final RequestQueue queue;

    private VolleyUtil() {
        queue = Volley.newRequestQueue(MyApp.context);
    }

    public static VolleyUtil getInstance(){
        if (volleyUtil==null){
            volleyUtil = new VolleyUtil();
        }
        return volleyUtil;
    }
    public boolean getNet(Context context){
         ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
            return false;
    }
    //GET方法
    public void toGet(String url, final IContract.CallBack callBack){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }
    //Post方法
    public void toPost(String url, final Map<String,String> map , final IContract.CallBack callBack){
        StringRequest request = new StringRequest(1,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }
}
