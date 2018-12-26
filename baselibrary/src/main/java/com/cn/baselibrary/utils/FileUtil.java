package com.cn.baselibrary.utils;


import java.io.File;
import java.io.FileNotFoundException;

/**
 * author by chenji on 2018/12/23
 */
public class FileUtil {

    public  static  void  makeFileDir (String dirPath) throws  Exception
    {
        File file=new File(dirPath);
        if(file.exists()){
            return;
        }
        file.mkdir();

    }
}
