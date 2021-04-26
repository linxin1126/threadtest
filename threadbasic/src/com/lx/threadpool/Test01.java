package com.lx.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:线程池的基本使用
 * @Author: LinXin_
 * @CreateTime: 2021/4/23 12:28
 */
public class Test01 {
    public static void main(String[] args) {
        //创建有5个线程大小的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        //向线程池中提交18个任务,这18个任务存储到线程池的阻塞队列中，线程池中这5个线程就从阻塞队列中取任务执行
        for (int i = 0; i < 18; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getId() + " 编号的线程在执行任务，开始时间：" + System.currentTimeMillis());
                        Thread.sleep(3000);     //模拟任务执行时长
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}