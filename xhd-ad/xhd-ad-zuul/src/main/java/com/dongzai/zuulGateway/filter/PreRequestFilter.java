package com.dongzai.zuulGateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 作者: xhd
 创建时间: 2019/8/16 10:21
 版本: V1.0
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // pre filter
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取当前请求的请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //记录请求进入时间
        requestContext.set("api_request_time", System.currentTimeMillis());
        return null;
    }
}
