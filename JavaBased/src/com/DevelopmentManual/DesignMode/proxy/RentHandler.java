package com.DevelopmentManual.DesignMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 作者: xhd
 * 创建时间: 2019/8/29 16:40
 * 版本: V1.0
 */
//自定义调用处理器
public class RentHandler implements InvocationHandler {
    Person landlord;

    public RentHandler(Person landlord) {
        this.landlord = landlord;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置处理
        System.out.println("经过前期调研，西湖边的房子环境挺好的...");
        //委托给真实角色处理业务逻辑
        method.invoke(landlord, args);
        //后置处理
        System.out.println("房子漏水，帮你联系维修人员...");
        return null;
    }

    public static void main(String[] args) {
        Person landlord = new Landlord();
        Person proxy = (Person) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Person.class}, new RentHandler(landlord));
        proxy.rent();
    }

}
