package com.yrsoft.generate.controller.tool;


import com.yrsoft.common.support.Convert;
import com.yrsoft.common.utils.JsonResult;


import com.yrsoft.generate.service.IGenService;
import org.apache.commons.io.IOUtils;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * 代码生成 操作处理
 * 
 * @author yrsoft
 */
@RestSchema(schemaId = "GenController")
@RequestMapping("/tool/gen")
public class GenController
{


    @Autowired
    private IGenService genService;

    /**
     * 批量生成代码
     */

    @RequestMapping(value = "/batchGenCode",method = RequestMethod.GET)
    public JsonResult batchGenCode(String tables) throws IOException
    {

        String path = "E:\\shipper.zip";
        String[] tableNames = Convert.toStrArray(tables);
        try {
            byte[] data = genService.generatorCode(tableNames);
            OutputStream os = new FileOutputStream(path);
            IOUtils.write(data,os);
            IOUtils.closeQuietly(os);
            return JsonResult.success(200,"写入到本地:"+path);
        } catch (IOException e) {
            return JsonResult.error(207,e.getMessage());
        }

    }


}