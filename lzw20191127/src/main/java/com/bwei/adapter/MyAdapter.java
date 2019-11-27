package com.bwei.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bwei.bean.MyBean;
import com.bwei.lzw20191127.Main2Activity;
import com.bwei.lzw20191127.MainActivity;
import com.bwei.lzw20191127.R;

import java.util.List;

/*
 *@auther:李泽炜
 *@Date: 2019/11/27
 *@Time:9:25
 *@Description:${DESCRIPTION}
 **/public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyBean.ResultBean> mlist;
    Context context;
    private int oneHolder =1;
    private int twoHolder =1;
    MainActivity mainActivity;
    public MyAdapter(List<MyBean.ResultBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        mainActivity = (MainActivity) context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        switch (i){
            case 1:
                View view = LayoutInflater.from(context).inflate(R.layout.one_layout,null);
                holder = new oneHolder(view);
                break;
            case 2:
                View view1 = LayoutInflater.from(context).inflate(R.layout.two_layout,null);
                holder = new oneHolder(view1);
                break;
                default:
                    break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof oneHolder){
            Glide.with(context)
                    .load(mlist.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(((oneHolder) viewHolder).img1);
            ((oneHolder) viewHolder).te1_one.setText(mlist.get(i).getCommodityName()+"");
            ((oneHolder) viewHolder).te1_two.setText(mlist.get(i).getCommodityId()+"");
            ((oneHolder) viewHolder).lin1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity, Main2Activity.class);
                    mainActivity.startActivity(intent);
                }
            });
        }else if (viewHolder instanceof twoHolder){
            Glide.with(context)
                    .load(mlist.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(((twoHolder) viewHolder).img2);
            ((twoHolder) viewHolder).te2_one.setText(mlist.get(i).getCommodityName()+"");
            ((twoHolder) viewHolder).te2_two.setText(mlist.get(i).getCommodityId()+"");
            ((twoHolder) viewHolder).lin2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity,Main2Activity.class);
                    mainActivity.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public class oneHolder extends RecyclerView.ViewHolder {
            ImageView img1;
            TextView te1_one;
            TextView te1_two;
            LinearLayout lin1;
        public oneHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            te1_one = itemView.findViewById(R.id.te1_one);
            te1_two = itemView.findViewById(R.id.te1_two);
            lin1 = itemView.findViewById(R.id.lin1);
        }
    }
    public class twoHolder extends RecyclerView.ViewHolder {
            ImageView img2;
            TextView te2_one;
            TextView te2_two;
            LinearLayout lin2;
        public twoHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img2);
            te2_one = itemView.findViewById(R.id.te2_one);
            te2_two = itemView.findViewById(R.id.te2_two);
            lin2 = itemView.findViewById(R.id.lin2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return oneHolder;
        }
            return twoHolder;
    }
}
