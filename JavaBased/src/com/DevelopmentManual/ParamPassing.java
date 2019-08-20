package com.DevelopmentManual;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 8:57
 * 版本: V1.0
 */
public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);
        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilderStatic);
    }

    //A方法
    public static void method(int intStatic) {
        intStatic = 777;
    }

    //B方法
    public static void method() {
        intStatic = 888;
    }

    //C方法
    public static void method(String stringStatic) {
        stringStatic = "new string";
    }

    //D方法
    public static void method(StringBuilder stringBuilderStaticl,
                              StringBuilder stringBuilderStatic2) {
        stringBuilderStaticl.append(".method.first-");
        stringBuilderStatic2.append("method.second-");
        stringBuilderStaticl = new StringBuilder("new stringBuilder");
        stringBuilderStaticl.append("new method's append");

    }

}
