package com.cn.chenji.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cn.baiduLibrary.interf.LocationInterf;
import com.cn.baiduLibrary.manager.BaiduManager;
import com.cn.chenji.R;
import com.cn.chenji.utils.SQLog;


public class LocationActivity extends AppCompatActivity {
    TextView textView;   //textview 用来展示地理位置信息


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);//百度定位例子
        textView=findViewById(R.id.exampleId);
        textView.setOnClickListener(new View.OnClickListener() {    //设置点击事件
            @Override
            public void onClick(View view) {
                BaiduManager.getInstance().getLocation(getApplicationContext(), new LocationInterf() {
                    @Override
                    public void onLocationSuccess(String location) {
                        SQLog.d("TAG",location);
                        textView.setText(location);
                    }

                    @Override
                    public void onLocationFail(String codeInfo) {
                        SQLog.d("TAG",codeInfo);
                    }
                });
            }
        });
    }
}


