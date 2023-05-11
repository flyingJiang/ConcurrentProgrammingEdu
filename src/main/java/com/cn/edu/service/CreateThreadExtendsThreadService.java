package com.cn.edu.service;

/**
 * @program: ConcurrentProgrammingEdu
 * @description: 继承Thread类创建多线程
 * 创建一个多线程需要执行两个步骤
 * <p>
 * 继承Thread类，创建一个新的线程类
 * 重写run()方法，将需要并发执行的业务代码编写在run()方法中
 * @author: jiangjianfei
 * @create: 2023-05-10 21:30
 **/
public class CreateThreadExtendsThreadService {

    private static final int MAX_TURN = 5;

    public static String getCurrentThread() {
        return Thread.currentThread().getName();
    }

    static class CreateThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < MAX_TURN; i++) {
                System.out.println("线程名称为：" + getCurrentThread());
            }
            System.out.println("线程名称为：" + getCurrentThread() + "运行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new CreateThread();
            thread.start();
        }
        System.out.println("线程名称为：" + getCurrentThread() + "运行结束");
    }

}
