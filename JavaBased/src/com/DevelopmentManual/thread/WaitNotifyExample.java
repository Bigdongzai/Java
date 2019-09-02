package com.DevelopmentManual.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者: xhd
 * 创建时间: 2019/9/2 9:42
 * 版本: V1.0
 */
public class WaitNotifyExample {

    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executorService.execute(() -> waitNotifyExample.after());
        executorService.execute(() -> waitNotifyExample.before());
    }
}
