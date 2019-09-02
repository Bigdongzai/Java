package com.DevelopmentManual.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 作者: xhd
 创建时间: 2019/9/2 8:43
 版本: V1.0
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("咦嘻嘻");
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
