package com.cn.chenji.application;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.io.File;

/**
 * author by chenji on 2018/12/6
 */
public class BaseActivity extends Activity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getApplicationContext();
    }

    public void initImageLoader(Context context) {
        //   This configuration tuning is custom. You can tune every option, you may tune some of them,
        //   or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        //  method.

    }
}