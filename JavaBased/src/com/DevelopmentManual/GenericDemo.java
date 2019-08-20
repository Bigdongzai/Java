package com.DevelopmentManual;

/**
 * 作者: xhd
 * 创建时间: 2019/8/20 13:42
 * 版本: V1.0
 */
public class GenericDemo<T> {
    //泛型 <>尖括号必须在类名之后或者方法返回值之前
    static <String, T, Xhd> String get(String str, Xhd xhd) {
        return str;
    }

    public static void main(String[] args) {
        Integer first = 666;
        Long second = 666L;
        Integer result = get(first, second);
    }
}
