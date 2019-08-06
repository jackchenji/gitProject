package greendao;

import android.content.Context;

import greendao.entity.Student;

/*
 *Created by chenji on 2019/8/5
 */ public class StudentDaoUtil {


     public static StudentDaoUtil instance;

    public StudentDaoUtil() {

    }


    public  static  StudentDaoUtil getInstance(){
        if(instance==null){

            instance=new StudentDaoUtil();
        }

        return  instance;
    }
    /**
     * 添加数据，如果有重复则覆盖
     */



    public void insertStudent(Student student, Context context) {
        DaoSessionManager.getInstace().getDaoSession(context).insertOrReplace(student);
    }


}
