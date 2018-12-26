package com.cn.baiduLibrary.view;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.PathUtils;
import android.widget.Toast;

import com.cn.baiduLibrary.utils.PathUtil;

import java.nio.file.Path;

/**
 * author by chenji on 2018/12/20
 * it is navigation activity
 */

//导航activity
public class NavigationActivity  extends Activity {
    String fileRootName= PathUtil.getSystemStoragePath()+"myGitDemo";    //系统根文件目录
    private static final String APP_FOLDER_NAME = "BNSDKSimpleDemo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* BaiduNaviManagerFactory.getBaiduNaviManager().init(NavigationActivity.this,fileRootName,APP_FOLDER_NAME,new IBaiduNaviManager.INaviInitListener() {

            @Override
            public void onAuthResult(int status, String msg) {
                String result;
                if (0 == status) {
                    result = "key校验成功!";
                } else {
                    result = "key校验失败, " + msg;
                }
                Toast.makeText(NavigationActivity.this, result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void initStart() {
                Toast.makeText(NavigationActivity.this, "百度导航引擎初始化开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void initSuccess() {
                Toast.makeText(NavigationActivity.this, "百度导航引擎初始化成功", Toast.LENGTH_SHORT).show();
               // hasInitSuccess = true;
                // 初始化tts
                //initTTS();
            }

            @Override
            public void initFailed() {
                Toast.makeText(NavigationActivity.this, "百度导航引擎初始化失败", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}