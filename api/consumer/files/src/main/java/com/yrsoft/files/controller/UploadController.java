package com.yrsoft.files.controller;


import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.files.entity.FilePath;
import com.yrsoft.files.entity.FilesType;
import com.yrsoft.files.service.FilesService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Arrays;

import javax.ws.rs.core.MediaType;

/**
 * @ClassName: UploadController
 * @Description:(文件上传类)
 * @author: JiaoWen
 * @date: 2019/2/25
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-12-13T03:46:29.119Z")

@RestSchema(schemaId = "filesUpload")
@RequestMapping(path = "/api/upload", produces = MediaType.APPLICATION_JSON)
public class UploadController {

    @Autowired
    private FilesService filesService;
    @Autowired
    private FilePath filePath;

    /**
     * 文件上传
     */
    @PostMapping(path = "/file/{type}/{param}",
            consumes = MediaType.MULTIPART_FORM_DATA)
    public JsonResult upload(@PathVariable("type") String type,
                             @PathVariable("param") String param,
                             @RequestPart(name = "file") MultipartFile file){


        //基本参数判断
        if(file.isEmpty()){
            return JsonResult.error(203,"文件上传异常，文件未获取");
        }
        if(type == null || "".equals(type)){
            return JsonResult.error(201,"路径参数异常");
        }
        if(param == null || "".equals(param)){
            return JsonResult.error(201,"路径参数异常");
        }
        if(filePath.getBasePath() == null || filePath.getReturnUrl() ==null || filePath.getFilesTypes()==null || filePath.getFileSize()==null ||filePath.getFileSuffix()==null  ){
            return JsonResult.error(203,"路径参数设置异常，请联系管理员");
        }

        /*
         * 文件合规性判断
         */
        if(file.getSize()/1024>filePath.getFileSize()){
            return JsonResult.error(203,"文件过大，不能大于"+filePath.getFileSize()+"kb");
        }
        String name = file.getName();
        String sourceFileName =  file.getOriginalFilename();
        String suffix =sourceFileName.substring((sourceFileName.lastIndexOf(".")+1));
        String [] suffixArray = filePath.getFileSuffix().split(",");
        if(!(Arrays.binarySearch(suffixArray,suffix)>0)){
            return JsonResult.error(201,"不支持此类文件上传");
        }

        //判断url是否正常
        int check = 0 ;
        FilesType filesType = null;
        for(FilesType ft : filePath.getFilesTypes()){
            if(ft.getParams()==null ||"".equals(ft.getParams())){
                return JsonResult.error(203,"路径参数设置异常，请联系管理员");
            }
            if(type.equals(ft.getType())){
                check = 1 ;
                filesType = ft;
                break;
            }
        }

        if (check ==0 || filesType == null  ||!filesType.getParams().contains(param)){
            return JsonResult.error(201,"路径参数异常");
        }

        //完成上传
        String savePath= filePath.getBasePath()+"/"+type+"/"+param+"/";
        String returnPath= filePath.getReturnUrl()+"/"+type+"/"+param+"/";
        return (filesService.uploadFile(file,savePath,returnPath ));

    }

}

