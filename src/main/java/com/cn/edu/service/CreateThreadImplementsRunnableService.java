package com.cn.edu.service;

/**
 * @program: ConcurrentProgrammingEdu
 * @description: 实现Runnable接口创建多线程
 * 将需要异步执行的业务逻辑代码写在Runnable实现类的run()方法中，再将Runnable实例作为target执行目标传入Thread实例，其完整步骤如下：
 * <p>
 * 定义一个新类实现Runnable接口
 * 实现Runnable接口中的run()抽象方法，将线程代码逻辑写在该run()实现方法中
 * 通过Thread类创建线程对象，将Runnable实例作为实际参数传递给Thread类的构造器，由Thread构造器将该Runnable实例赋值给自己的target执行目标属性
 * 调用Thread实例的start()方法启动线程
 * 线程启动之后，线程的run()方法将被JVM执行，该run()方法将调用target属性的run()方法，从而完成Runnable实现类中业务代码逻辑的并发执行
 * ————————————————
 * 版权声明：本文为CSDN博主「渝州居士」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/liu320yj/article/details/125703535
 * @author: jiangjianfei
 * @create: 2023-05-10 21:36
 **/
public class CreateThreadImplementsRunnableService {

    private static final int MAX_TURN = 5;

    public static String getCurrentThread() {
        return Thread.currentThread().getName();
    }

    static class CreateThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_TURN; i++) {
                System.out.println("当前线程名称为：" + getCurrentThread());
            }
            System.out.println("当前线程名称为：" + getCurrentThread() + "运行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 2; i++) {
            Runnable runnable = new CreateThread();
            thread = new Thread(runnable);
            thread.start();
        }
    }
}
