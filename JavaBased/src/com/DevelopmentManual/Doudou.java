package com.DevelopmentManual;

import java.sql.SQLClientInfoException;
/**
 * 作者: xhd
 * 创建时间: 2019/8/20 9:36
 * 版本: V1.0
 */
public class Doudou extends Xhd {
    static {
        System.out.println("son静态方法");
    }

    public Doudou() {
        System.out.println("son构造器");
    }

    /*  覆写 @Override 一大二小二同
        一大 权限扩大 protected到public
        二小 返回数据类型及抛出异常 变小
        二同 方法名和参数相同*/
    @Override
    public Integer doSomething(int a, Integer b, Object c) throws SQLClientInfoException {
        if (a == 0) {
            throw new SQLClientInfoException();
        }
        return new Integer(8);
    }

    public static void main(String[] args) {
        new Doudou();
        new Doudou();
    }
}
