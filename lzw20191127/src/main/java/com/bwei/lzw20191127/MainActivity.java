package com.bwei.lzw20191127;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.bwei.adapter.MyAdapter;
import com.bwei.api.MyApi;
import com.bwei.base.BaseActivity;
import com.bwei.base.BasePresenter;
import com.bwei.bean.MyBean;
import com.bwei.contract.IContract;
import com.bwei.presenter.MyPresenter;
import com.bwei.util.VolleyUtil;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends BaseActivity implements IContract.IView , MyView.oncall{
    private RecyclerView re_view;
    private MyView my_view;
    private FlowView flow;
    @Override
    protected void initData() {
        boolean net = VolleyUtil.getInstance().getNet(this);
        if (net){
            String s = URLEncoder.encode("板鞋");
            MyPresenter myPresenter = (MyPresenter) p;
            myPresenter.success(MyApi.url(s));
        }else {
            Toast.makeText(this, "无网", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void initView() {
        re_view = findViewById(R.id.re_view);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        re_view.setLayoutManager(gridLayoutManager);
        my_view = findViewById(R.id.my_view);
        my_view.setCall(this);
        flow = findViewById(R.id.flow);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(MyBean myBean) {
        List<MyBean.ResultBean> mlist = myBean.getResult();
        MyAdapter myAdapter = new MyAdapter(mlist, MainActivity.this);
        re_view.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onclick() {
        String ss = my_view.ed_one.getText().toString();
        flow.addTag(ss);
        MyPresenter myPresenter = (MyPresenter) p;
        myPresenter.success(MyApi.url(ss));
    }
}
