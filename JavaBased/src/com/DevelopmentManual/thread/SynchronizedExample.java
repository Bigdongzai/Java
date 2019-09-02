package com.DevelopmentManual.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者: xhd
 * 创建时间: 2019/9/2 9:07
 * 版本: V1.0
 */
public class SynchronizedExample {
    public void fun1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.fun1());
        executorService.execute(() -> synchronizedExample.fun1());
    }
}
