package com.cn.chenji.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.HashMap;
import java.util.List;




public class GetPackageNameUtil {


    //调用以上方法即可获取到所有应用的名字与包名.
    public static  HashMap<String,String> getAllAppNamesPackages(Context context){
        int i=0;
        HashMap<String,String>  appMap=new HashMap<String,String>();
        PackageManager pm=context.getPackageManager();
        List<PackageInfo> list=pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (PackageInfo packageInfo : list) {
            //获取到设备上已经安装的应用的名字,即在AndriodMainfest中的app_name。
            String appName=packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            //获取到应用所在包的名字,即在AndriodMainfest中的package的值。
            String packageName=packageInfo.packageName;
            i++;
            appMap.put(packageName,appName);
        }
        return  appMap;
    }
}