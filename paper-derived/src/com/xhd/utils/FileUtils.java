package com.xhd.utils;

import java.io.File;

/**
 作者: xhd
 创建时间: 2019/8/21 13:16
 版本: V1.0
 */
public class FileUtils {
    public static void createFile(String path){
        File file=new File(path);
        try {
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();

        }catch (Exception E){

        }

    }
}
