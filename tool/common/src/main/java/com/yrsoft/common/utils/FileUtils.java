package com.yrsoft.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: FileUtils
 * @Description:(文件上传下载等内容)
 * @author: JiaoWen
 * @date: 2019/2/25
 */

public class FileUtils {

    /**
     * @Title: uploadFile
     * @author: JiaoWen
     * @Description: (上传文件)
     * @Date:  2019/2/25
     * @param: [sourceFile, copyPath] (必填参数详解)
     * @return:  java.lang.String
     */
    public static String uploadFile(MultipartFile sourceFile, String copyPath){
        String sourceFileName =  sourceFile.getOriginalFilename();
        String suffix =sourceFileName.substring((sourceFileName.lastIndexOf(".")));
        String filePath = copyPath+creatNum()+suffix;

        try {
            sourceFile.transferTo(new File(filePath));
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * @Title: copyFile
     * @author: JiaoWen
     * @Description: (文件拷贝)
     * @Date:  2019/2/25
     * @param: [file, copyPath] (file 要被复制的文件，需要复制到的位置)
     * @return:  java.lang.String
     */
    public static String copyFile(File sourceFile, String copyPath) {
        //创建新的文件名及文件地址
        String sourceFileName =  sourceFile.getName();
        String suffix =sourceFileName.substring((sourceFileName.lastIndexOf(".")));
        String filePath = copyPath+creatNum()+suffix;
        File cpFile = new File(filePath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        //执行文件复制
        try {
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(cpFile);
            byte[] bt = new byte[1024];
            int realbyte = 0;
            while ((realbyte = fileInputStream.read(bt)) > 0) {
                fileOutputStream.write(bt,0,realbyte);
            }

            fileInputStream.close();
            fileOutputStream.close();
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }






    /**
     * 生成文件编号
     * 规则时间到毫秒加4位随数
    */
    private static String creatNum(){
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateString = simpleDateFormat.format(currentTime);

        /**
         * 取随机数并拼接
         */
        dateString = dateString+String .valueOf((int)((Math.random()*9+1)*1000));
        return dateString;

    }
}
