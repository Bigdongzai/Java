package com.dongzai.zuulGateway.filter;/**
 * Copyright (c) 2018-2019 All rights reserved.
 * 项目名称：新能源汽车V2.0
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 作者: xhd
 * 创建时间: 2019/8/16 10:24
 * 版本: V1.0
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        //需要最后一个执行的filter
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("Request \"{}\" spent : {} seconds.", request.getRequestURI(),
                (System.currentTimeMillis() - Long.valueOf(requestContext.get("api_request_time").toString())) / 1000);
        return null;
    }
}
