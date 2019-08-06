package greendao;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.cn.baselibrary.R;

import greendao.entity.Student;

/*
 *Created by chenji on 2019/8/5
 */ public class GreenDaoActivity extends Activity {
     LinearLayout add;
    LinearLayout delete;
    LinearLayout modify;
    LinearLayout query;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greendao);
        add=findViewById(R.id.add);
        delete=findViewById(R.id.delete);
        modify=findViewById(R.id.modify);
        query=findViewById(R.id.query);
        onClick();
        }

        int id=100;
        int studentid=200;
       private void onClick(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id++;
                studentid++;
                StudentDaoUtil.getInstance().insertStudent(new Student(id,studentid,35,"17802180258","28","chenjiwahahaha","hunanlongshangxiang","shenghang","6"),GreenDaoActivity.this.getApplicationContext());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       }



}
