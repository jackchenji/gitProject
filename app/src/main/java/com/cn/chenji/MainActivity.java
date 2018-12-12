package com.cn.chenji;

import android.content.Intent;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.cn.chenji.adapter.ViewAdapter;
import com.cn.chenji.application.BaseActivity;
import com.cn.chenji.view.LocationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity{
    @BindView(R.id.rv)
    RecyclerView  mRecyclerView;
    private List<String>  viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ButterKnife.bind(this);
        mRecyclerView=findViewById(R.id.rv);
        viewList=new ArrayList<>();
        viewList.add("百度定位");
        viewList.add("百度地图");
        viewList.add("百度导航");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("百度AR");
        viewList.add("");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置item增加和删除时的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        ViewAdapter viewAdapter=new ViewAdapter(viewList,mContext);
        mRecyclerView.setAdapter(viewAdapter);
        viewAdapter.onItemClickListener(new ViewAdapter.onItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Log.i("test","点击的第几项"+position);
                switch (position)
                {
                    case  0:
                        Intent  intent=new Intent(MainActivity.this,LocationActivity.class);
                        mContext.startActivity(intent);
                        break;
                        default: break;
                }

            }
        });
        }
}