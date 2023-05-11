package com.cn.edu.service;

/**
 * @program: ConcurrentProgrammingEdu
 * @description: 通过匿名类创建Runnable线程目标类
 * 如果target实现类是一次性类，可以使用匿名实例，代码如下：
 * @author: jiangjianfei
 * @create: 2023-05-10 21:38
 **/
public class CreateThreadImplementsRunnableInnerClassService {
    private static final int MAX_TURN = 5;
    static int threadNo = 1;

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < MAX_TURN; j++) {
                        System.out.println("多线程执行，第：" + j + "次执行!");
                    }
                    System.out.println("运行结束");
                }
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        System.out.println("运行结束");
    }
}
