package com.dongzai.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 作者: xhd
 * 创建时间: 2019/8/16 15:39
 * 版本: V1.0
 */
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //清空所有转换器
        converters.clear();
        // Java Obj -> Json Obj (http header: application/json)
        converters.add(new MappingJackson2HttpMessageConverter());

    }
}
