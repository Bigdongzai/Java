package com.DevelopmentManual;

import java.sql.SQLException;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 9:35
 * 版本: V1.0
 */
public class Xhd {
    static {
        System.out.println("Father静态方法");
    }

    public Xhd() {
        System.out.println("Father构造器");
    }

    protected Number doSomething(int a, Integer b, Object c) throws SQLException {
        System.out.println("yixixi");
        return new Integer(7);
    }


}
