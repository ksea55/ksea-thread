package org.ksea.thread;

/**
 * Created by mexican on 2016/7/29.
 * 初识线程、通过继承Thread的方式
 */
public class InitialThread {

    public static void main(String[] args) {

        //创建线程的第一种方式,这里直接使用的是匿名内部类
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //线程阻塞5秒
                    try {
                        Thread.sleep(500);
                        System.out.println("当前运行线程:" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //开启线程
        t1.start();

        //创建线程第二种方式
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    //线程阻塞5秒
                    try {
                        Thread.sleep(500);
                        System.out.println("当前运行的线程是:"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //开启第二个线程
        t2.start();


       /*第三种线程方式解答*/
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    //线程阻塞5秒
                    try {
                        Thread.sleep(500);
                        System.out.println("当前在Runnable中运行的线程是:"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }){
            @Override
            public void run() {
                while (true) {
                    //线程阻塞5秒
                    try {
                        Thread.sleep(500);
                        System.out.println("当前在Thread中运行的线程是:"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        /*阐述说明:在第三种创建线程的方式中,使用匿名子类的时候，当开启线程的时候首先会运行子类中的方法
        * 也就是 System.out.println("当前在Thread中运行的线程是:"+Thread.currentThread().getName());
        * 而new 的Runnable接口，来自于父类Thread,当匿名类中未重写 run方法时，会去调用父类的方法
        * 也就是 System.out.println("当前在Runnable中运行的线程是:"+Thread.currentThread().getName());
        *
        * */
    }

}

