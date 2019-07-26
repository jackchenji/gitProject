package picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cn.baselibrary.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView imagelist;
    private ImagelistAdapter adapter;
    //放图片资源的集合
    private ArrayList<String> list =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baselib_activity_main);
        imagelist= (ListView) findViewById(R.id.imagelist);
        list.add("http://h.hiphotos.baidu.com/image/w%3D310/sign=53d5f82103e9390156028b3f4bec54f9/574e9258d109b3deb38ea469cebf6c81800a4cf9.jpg");
        list.add("http://c.hiphotos.baidu.com/image/w%3D310/sign=1214242166380cd7e61ea4ec9145ad14/ae51f3deb48f8c5436841ebe39292df5e1fe7fc8.jpg");
        list.add("http://c.hiphotos.baidu.com/image/w%3D310/sign=4bebf5c06e81800a6ee58f0f813433d6/7c1ed21b0ef41bd537dde4bb53da81cb38db3df6.jpg");
        adapter=new ImagelistAdapter(MainActivity.this,list);
        imagelist.setAdapter(adapter);
        }

 }

