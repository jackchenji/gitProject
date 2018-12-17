package com.cn.baiduLibrary.view;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.cn.baiduLibrary.R;
import com.cn.baiduLibrary.interf.LocationInterf;
import com.cn.baiduLibrary.manager.BaiduManager;
import com.cn.baiduLibrary.utils.SQLog;

public class BaiduMapActivity extends AppCompatActivity {
    private   MapView  mapView;
    private com.baidu.mapapi.map.BaiduMap baiduMap = null;
    private   MapStatus.Builder builder = new MapStatus.Builder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
        setContentView(R.layout.activity_baidu_map);
        mapView=findViewById(R.id.baiduMap);
        baiduMap=mapView.getMap();
        BaiduManager.getInstance().getLocation(getApplicationContext(), new LocationInterf() {
            @Override
            public void onLocationSuccess(String location) {
                SQLog.d("TAG",location);
                String[]  locationArray=location.split("，");
                if(locationArray!=null&&locationArray.length>0){
                    LatLng center = new LatLng(Double.parseDouble(locationArray[0]),Double.parseDouble(locationArray[1]));
                    float zoom = 18.0f; // 默认 18级
                    builder.target(center).zoom(zoom);
                    baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder
                            .build()));
                }
            }
            @Override
            public void onLocationFail(String codeInfo) {
                SQLog.d("TAG",codeInfo);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();

    }
}
