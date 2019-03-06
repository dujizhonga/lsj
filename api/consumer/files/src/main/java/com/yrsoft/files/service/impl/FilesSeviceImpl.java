package com.yrsoft.files.service.impl;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.files.entity.FilePath;
import com.yrsoft.files.service.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: FilesSeviceImpl
 * @Description:(文件管理)
 * @author: JiaoWen
 * @date: 2019/3/4
 */
@Service
public class FilesSeviceImpl implements FilesService {
    /**
     * @Title: uploadFile
     * @author: JiaoWen
     * @Description: (上传文件)
     * @Date:  2019/2/25
     * @param: [sourceFile, copyPath] (必填参数详解)
     * @return:  java.lang.String
     */
    public JsonResult uploadFile(MultipartFile sourceFile, String savePath ,String returnPath){

        String sourceFileName =  sourceFile.getOriginalFilename();
        String suffix =sourceFileName.substring((sourceFileName.lastIndexOf(".")));
        String filePath = savePath+creatNum()+suffix;
        String returnUrl =  returnPath+creatNum()+suffix;
        try {
            sourceFile.transferTo(new File(filePath));
            return JsonResult.createResponse(200,"上传成功",returnUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonResult.createResponse(205,"上传失败",null);
    }


    /**
     * @Title: downloadFile
     * @author: JiaoWen
     * @Description: (文件下载服务)
     * @Date:  2019/3/6
     * @param: [downPath] (必填参数详解)
     * @return:  com.yrsoft.common.utils.JsonResult
     */
    public File downloadFile (String downPath){
        File file = new File(downPath);
        if(!file.exists()){
            return null;
        }
        return file;

    }


    /**
     * @Title: cleanTempFile
     * @author: JiaoWen
     * @Description: (临时文件清除)
     * @Date:  2019/3/6
     * @param: [file] (必填参数详解)
     * @return:  void
     */
    public void cleanTempFile(MultipartFile file)  {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                closeIs(inputStream);
            }
        }
    }
    private void closeIs(InputStream is){
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * @Title: creatNum
     * @author: JiaoWen
     * @Description: (用于生成文件名)
     * @Date:  2019/3/4
     * @return:  java.lang.String
     */
    private String creatNum(){

        /**
         * 格式化时间
         */
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
