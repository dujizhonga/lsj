package com.yrsoft.files.service;

import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.files.entity.FilePath;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FilesService {
    public JsonResult uploadFile (MultipartFile sourceFile, String savePath ,String returnPath);
    public void cleanTempFile(MultipartFile file);
    public File downloadFile (String downPath);
}
