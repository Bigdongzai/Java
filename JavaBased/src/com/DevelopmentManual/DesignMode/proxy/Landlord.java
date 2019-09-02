package com.DevelopmentManual.DesignMode.proxy;

/**
 * 作者: xhd
 * 创建时间: 2019/8/29 16:38
 * 版本: V1.0
 */
//真实角色 干活的人
public class Landlord implements Person {
    @Override
    public void rent() {
        System.out.println("我是真实的房东啊！");
    }
}
