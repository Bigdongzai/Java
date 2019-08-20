package com.DevelopmentManual;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 13:24
 * 版本: V1.0
 */
public class OverLoadMethods {
    //方法签名 修饰符+方法名+参数
    //JVM重载 ：
    //（1）精准匹配
    //（2）如果基本数据类型 自动转换更大表示范围的基本数据类型
    //（3）通过自动拆箱和装箱
    //（4）通过子类向上转型继承路线依次匹配
    //（5）通过可变参数匹配
    public void overLoadMethod() {
        System.out.println("无参方法");
    }

    public void overLoadMethod(int param) {
        System.out.println("参数为int类型");
    }

    public void overLoadMethod(Integer param) {
        System.out.println("参数为Integer类型");
    }

    public void overLoadMethod(Integer... param) {
        System.out.println("可变参数");
    }

    public void overLoadMethod(Object param) {
        System.out.println("参数为Object类型");
    }

    public static void main(String[] args) {
        new OverLoadMethods().overLoadMethod(2);
    }

}
