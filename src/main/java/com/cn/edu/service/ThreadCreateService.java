package com.cn.edu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: ConcurrentProgrammingEdu
 * @description: 创建多线程
 * @author: jiangjianfei
 * @create: 2023-05-10 21:08
 **/
@Slf4j
@Service
public class ThreadCreateService {


    /**
     * 每次创建一个线程，频繁的创建、销毁，浪费了系统资源，这时可以采用线程池
     */
    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("This is a thread -" + Thread.currentThread().getName());
        }
    }
//
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//    }

//    @Bean(name = "executorService")
//    public ExecutorService executorService() {
//        return new ThreadPoolExecutor(20, 40, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000),
//                new ThreadFactoryBuilder().setNameFormat("defaultExecutorService-%d").build(),
//                (r, executor) -> log.error("defaultExecutor pool is full! "));
//    }
//
//    public static ExecutorService executorService = new ThreadPoolExecutor(
//            4,
//            40,
//            0L,
//            TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(1024),
//            new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(),
//            (r, executor) -> System.out.println("defaultExecutor pool is full! "));

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "异步处理，Callable 返回结果";
        }
    }

//    public static void main(String[] args) {
//        Future<String> future = executorService.submit(new MyCallable());
//        try {
//            System.out.println(future.get());
//        } catch (Exception e) {
//        } finally {
//            executorService.shutdown();
//        }
//    }


}
