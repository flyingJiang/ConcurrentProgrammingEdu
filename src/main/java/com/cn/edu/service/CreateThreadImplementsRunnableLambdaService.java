package com.cn.edu.service;

/**
 * @program: ConcurrentProgrammingEdu
 * @description: 使用Lambda表达式创建Runnable线程目标类
 * Runnable接口是一个函数式接口，在接口实现时可以使用Lambda表达式提供匿名实现，其代码实现如下：
 * @author: jiangjianfei
 * @create: 2023-05-10 21:41
 **/
public class CreateThreadImplementsRunnableLambdaService {
    private static final int MAX_TURN = 5;
    private static int threadNo = 1;

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new Thread(() -> {
                for (int j = 0; j < MAX_TURN; j++) {
                    System.out.println("多线程执行，第:" + j + "次执行!");
                }
                System.out.println("多线程运行结束");
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        System.out.println("多线程运行结束");
    }
}
