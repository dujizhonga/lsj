package com.yrsoft.files.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @ClassName: FileTes
 * @Description:(这里用一句话描述这个类的作用)
 * @author: JiaoWen
 * @date: 2019/3/4
 */

@Component
@ConfigurationProperties(prefix = "filePath")
@Validated
public class FilePath {
    private String basePath;
    private String returnUrl;
    private Integer fileSize;
    private String fileSuffix;
    private List<FilesType> filesTypes;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }


    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public List<FilesType> getFilesTypes() {
        return filesTypes;
    }

    public void setFilesTypes(List<FilesType> filesTypes) {
        this.filesTypes = filesTypes;
    }


}
