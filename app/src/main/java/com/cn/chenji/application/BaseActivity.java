package com.cn.chenji.application;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;
import java.security.Permission;

import rx.functions.Action1;

/**
 * author by chenji on 2018/12/6
 */
public class BaseActivity extends Activity {

    public Context mContext;
    protected    String[] permission=new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getApplicationContext();
        RxPermissions.getInstance(mContext).requestEach(permission).subscribe(new Action1<com.tbruyelle.rxpermissions.Permission>() {
            @Override
            public void call(com.tbruyelle.rxpermissions.Permission permission) {
                //多个权限
            }
        });
    }

    public void initImageLoader(Context context) {

    }
}