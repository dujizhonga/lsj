package com.yrsoft.files.controller;

import com.yrsoft.files.entity.FilePath;
import com.yrsoft.files.service.FilesService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.ws.rs.core.MediaType;
import java.io.File;

/**
 * @ClassName: DownLoadController
 * @Description:(处理文件下载)
 * @author: JiaoWen
 * @date: 2019/2/25
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-12-13T03:46:29.119Z")

@RestSchema(schemaId = "filesDownload")
@RequestMapping(path = "/api/show", produces = MediaType.APPLICATION_JSON)
public class DownLoadController {

    @Autowired
    private FilesService filesService;
    @Autowired
    private FilePath filePath;
    /**
     * 文件下载
     */
    @PostMapping(path = "/file/{type}/{param}/{fileName}")
    public File downLoad(@PathVariable("type") String type,
                         @PathVariable("param") String param,
                         @PathVariable("fileName") String fileName
    ){

        String downPath = filePath.getBasePath()+"/"+type+"/"+param+"/"+fileName;
        return  filesService.downloadFile(downPath);
    }

}
