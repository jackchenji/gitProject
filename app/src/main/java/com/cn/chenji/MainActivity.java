package com.cn.chenji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.cn.baiduLibrary.view.BaiduMapActivity;
import com.cn.baiduLibrary.view.LocationActivity;
import com.cn.baiduLibrary.view.NavigationActivity;
import com.cn.chenji.adapter.ViewAdapter;
import com.cn.chenji.application.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


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
                Intent  intent;
                switch (position)
                {
                    case  0:
                        intent=new Intent(MainActivity.this,LocationActivity.class);  //百度定位
                        break;
                    case   1:
                         intent=new Intent(MainActivity.this, BaiduMapActivity.class);      //百度地图
                        break;
                        case 2:
                        intent=new Intent(MainActivity.this, NavigationActivity.class);      //导航页面
                    default: intent=new Intent(MainActivity.this, MainActivity.class);
                        break;
                }
               if(intent!=null){
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);}
            }
        });
        }
}