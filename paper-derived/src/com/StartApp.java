package com;

import com.xhd.service.AssemblyPaperService;
import com.xhd.utils.PropertiesUtils;
import java.util.Properties;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 15:54
 * 版本: V1.0
 */
public class StartApp {
    public static void main(String[] args) throws Exception {
        System.out.println("start------------------------------------------------------");
        Properties paramConf = PropertiesUtils
                .getConfig(System.getProperty("user.dir") + "/conf.properties");
        new AssemblyPaperService().assembly(paramConf);
        System.out.println("end--------------------------------------------------------");
    }
}
