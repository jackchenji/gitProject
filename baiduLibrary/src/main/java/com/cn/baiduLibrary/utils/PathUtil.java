package com.cn.baiduLibrary.utils;

import android.os.Environment;

/**
 * author by chenji on 2018/12/23
 */
//获取手机系统的path
public class PathUtil {

    //获取手机系统的根目录的路径
    public  static  String getSystemStoragePath() {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return Environment.getExternalStorageDirectory().getPath().toString()+"/";
            }
        return "";
    }

}

