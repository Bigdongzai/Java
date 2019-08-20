package com.DevelopmentManual;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 9:50
 * 版本: V1.0
 */
public class StaticCode {
    static String prior = "done";

    static String last = f() ? g() : prior;

    public static boolean f() {
        return true;
    }

    public static String g() {
        return "xhd";
    }

    static {
        System.out.println(last);
        g();
    }

    public static void main(String[] args) {
        new StaticCode();
    }
}
