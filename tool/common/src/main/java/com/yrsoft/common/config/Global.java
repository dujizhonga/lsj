package com.yrsoft.common.config;


import com.yrsoft.common.utils.StringUtils;
import com.yrsoft.common.utils.YamlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 * 
 * @author yrsoft
 */
public class Global
{
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static String NAME = "application.yml";

    private static String NAME_BETA = "application_beat.yml";

    private static String NAME_DEV = "application_dev.yml";

    /**
     * 当前对象实例
     */
    private static Global global = null;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    private Global()
    {
    }

    /**
     * 静态工厂方法 获取当前对象实例 多线程安全单例模式(使用双重同步锁)
     */

    public static synchronized Global getInstance()
    {
        if (global == null)
        {
            synchronized (Global.class)
            {
                if (global == null)
                    global = new Global();
            }
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key)
    {

        String value = map.get(key);
        if (value == null)
        {
            Map<?, ?> yamlMap = null;
            Map<?, ?> yamlMapBeta = null;
            Map<?, ?> yamlMapDev = null;
            try
            {
                yamlMap = YamlUtil.loadYaml(NAME);
                //获取激活配置
                String activation = StringUtils.objToStr(YamlUtil.getProperty(yamlMap, "activation.file"));

                 value = StringUtils.objToStr(YamlUtil.getProperty(yamlMap, key));
                 map.put(key, value != null ? value : StringUtils.EMPTY);




                 if (StringUtils.isNotBlank(activation)&&StringUtils.equals("beat",activation)){
                     yamlMapBeta = YamlUtil.loadYaml(NAME_BETA);
                     String valueBeat = StringUtils.objToStr(YamlUtil.getProperty(yamlMapBeta, key));
                     if (StringUtils.isNotBlank(valueBeat)){
                         value = valueBeat;
                     }
                     if (StringUtils.isNotBlank(valueBeat)&&StringUtils.isNotBlank(value)){
                         value = valueBeat;
                     }
                     map.put(key, value != null ? value : StringUtils.EMPTY);

                 }

                if (StringUtils.isNotBlank(activation)&&StringUtils.equals("dev",activation)){
                    yamlMapDev = YamlUtil.loadYaml(NAME_DEV);
                    String valueDev = StringUtils.objToStr(YamlUtil.getProperty(yamlMapDev, key));
                    if (StringUtils.isNotBlank(valueDev)){
                        value = valueDev;
                    }
                    if (StringUtils.isNotBlank(valueDev)&&StringUtils.isNotBlank(value)){
                        value = valueDev;
                    }
                    map.put(key, value != null ? value : StringUtils.EMPTY);
                }

            }
            catch (FileNotFoundException e)
            {
                log.error("获取全局配置异常 {}", key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName()
    {
        return StringUtils.nvl(getConfig("yrsoft.name"), "yrsoft");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion()
    {
        return StringUtils.nvl(getConfig("yrsoft.version"), "3.2.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear()
    {
        return StringUtils.nvl(getConfig("yrsoft.copyrightYear"), "2018");
    }

    /**
     * 获取ip地址开关
     */
    public static Boolean isAddressEnabled()
    {
        return Boolean.valueOf(getConfig("yrsoft.addressEnabled"));
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile()
    {
        return getConfig("yrsoft.profile");
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getConfig("yrsoft.profile") + "avatar/";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getConfig("yrsoft.profile") + "download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getConfig("yrsoft.profile") + "upload/";
    }

    /**
     * 获取作者
     */
    public static String getAuthor()
    {
        return StringUtils.nvl(getConfig("gen.author"), "yrsoft");
    }

    /**
     * 生成包路径
     */
    public static String getPackageName()
    {
        return StringUtils.nvl(getConfig("gen.packageName"), "com.yrsoft.project.module");
    }

    /**
     * 是否自动去除表前缀
     */
    public static String getAutoRemovePre()
    {
        return StringUtils.nvl(getConfig("gen.autoRemovePre"), "true");
    }

    /**
     * 表前缀(类名不会包含表前缀)
     */
    public static String getTablePrefix()
    {
        return StringUtils.nvl(getConfig("gen.tablePrefix"), "sys_");
    }

    /**
     * 请求加密
     */
    public static boolean getRequestAES(){

        String config = getConfig("aesjm.request");
        if (StringUtils.isBlank(config)){
            return true;
        }
        return Boolean.valueOf(config);
    }

    /**
     * 响应加密
     */
    public static boolean getResponseAES(){
        String config = getConfig("aesjm.response");
        if (StringUtils.isBlank(config)){
            return true;
        }
        return Boolean.valueOf(config);
    }

    /**
     * 测试地址
     * @return
     */
    public static String getUrl(){
        String config = getConfig("url.test");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }
    
    /**
     * 获取地址
     * @return
     */
    public static String getUrl(String url){
        String config = getConfig("url."+url);
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }

    /**
     * 测试地址
     * @return
     */
    public static String getAuth(){
        String config = getConfig("url.auth");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }

    /**
     * 测试地址
     * @return
     */
    public static String getMember(){
        String config = getConfig("url.member");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }

    /**
     * 测试地址
     * @return
     */
    public static String getOperate(){
        String config = getConfig("url.operate");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }
    /**
     * 测试地址
     * @return
     */
    public static String getPlatform(){
        String config = getConfig("url.platform");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }
    /**
     * 测试地址
     * @return
     */
    public static String getPosition(){
        String config = getConfig("url.position");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }

    /**
     * 测试地址
     * @return
     */
    public static String getSystem(){
        String config = getConfig("url.system");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }
    /**
     * 测试地址
     * @return
     */
    public static String getWebsite(){
        String config = getConfig("url.website");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }

    /**
     * 测试地址
     * @return
     */
    public static String getFinance(){
        String config = getConfig("url.finance");
        if (StringUtils.isBlank(config)){
            return "";
        }
        return config;
    }


}


