package com.cn.chenji.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.cn.chenji.MainActivity;
import com.cn.chenji.R;
import com.cn.chenji.application.BaseActivity;
import com.cn.chenji.utils.StatusBarUtil;

//启动页演示

public class SplashActivity extends BaseActivity {
  Intent   mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 去掉标题栏
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.splash_color));
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                mIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mIntent);
                finish();
                return false;
            }
        }).sendEmptyMessageDelayed(0,3000);//启动页3秒动画

    }
}
