package com.xhd.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 作者: xhd
 * 创建时间: 2019/8/21 10:22
 * 版本: V1.0
 */
public class ArithmeticUtils {
    /**
     * 功能：产生min-max中的n个不重复的随机数
     * <p>
     * min:产生随机数的其实位置
     * mab：产生随机数的最大位置
     * n: 所要产生多少个随机数
     */
    public static int[] randomNumber(int min, int max, int n) {

        //判断是否已经达到索要输出随机数的个数
        if (n > (max - min + 1) || max < min) {
            return null;
        }

        int[] result = new int[n]; //用于存放结果的数组

        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < count; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    /**
     * 功能：随机指定范围内N个不重复的数
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomSet(int min, int max, int n) {
        Set<Integer> set = new HashSet<Integer>();
        int[] array = new int[n];
        for (; true; ) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;

            // 将不同的数存入HashSet中
            set.add(num);
            // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
            if (set.size() >= n) {
                break;
            }
        }
        int i = 0;
        for (int a : set) {
            array[i] = a;
            i++;
        }
        return array;
    }

    /**
     * 功能：随机指定范围内N个不重复的数
     *
     * @param max 指定范围最大值
     * @param min 指定范围最小值
     * @param n   随机数个数
     */
    public static int[] randomArray(int min, int max, int n) {
        int len = max - min + 1;

        if (max < min || n > len) {
            return null;
        }

        // 初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            // 待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            // 将随机到的数放入结果集
            result[i] = source[index];
            // 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ss = randomArray(0, 10, 11);
        for (int s : ss) {
            System.out.println(s);
        }
    }
}
