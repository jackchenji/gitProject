package com.cn.baiduLibrary.manager;

import android.content.Context;

 import com.cn.baiduLibrary.interf.BaiduInterf;
import com.cn.baiduLibrary.interf.LocationInterf;
import com.cn.baiduLibrary.location.LocationService;


/**
 *author by chenji on 2018/11/25
 */
public class BaiduManager implements BaiduInterf {
    public  static  BaiduManager mBaiduManager;

    public static BaiduManager  getInstance(){    //获取单例对象
        if(mBaiduManager==null){
            mBaiduManager=new BaiduManager();
        }
        return  mBaiduManager;
    }


    @Override
    public String getLocation(Context context,LocationInterf locationInterf) {
        LocationService locationService= new LocationService(context,locationInterf);
        locationService.startLocate();
        return null;
    }


}
