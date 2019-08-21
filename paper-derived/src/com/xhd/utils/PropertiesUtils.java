package com.xhd.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * 作者: xhd
 * 创建时间: 2019/8/21 9:29
 * 版本: V1.0
 */
public class PropertiesUtils {

    /**
     * 配置缓存文件。
     */
    private static HashMap<String, Properties> propertiesMap = new HashMap<String, Properties>();

    /**
     * 获取配置文件。
     *
     * @param filepath
     * @return
     */
    public static Properties getConfig(String filepath) {
        if (propertiesMap.containsKey(filepath)) {
            return propertiesMap.get(filepath);
        }
        InputStream inStream = null;
        Properties prop = new Properties();
        try {
            inStream = new FileInputStream(new File(filepath));
            prop.load(new InputStreamReader(inStream, "UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        propertiesMap.put(filepath, prop);
        return prop;
    }
}
