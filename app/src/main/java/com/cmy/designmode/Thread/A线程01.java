package com.cmy.designmode.Thread;

import android.util.Log;

import com.cmy.designmode.arithmetic.排序;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 *
 *
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 15:55
 */
public class A线程01 {

    private static Lock sLock;

    public static void main(String[] args){

        //固定个数线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //一个线程 它确保所有任务进来都要排队按顺序执行
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //它是一个数量无限多的线程池，它所有的线程都是非核心线程 空闲60s都会被回收
        ExecutorService executorService2 = Executors.newCachedThreadPool();
       //它有数量固定的核心线程，且有数量无限多的非核心线程，但是它的非核心线程超时时间是0s，
        // 所以非核心线程一旦空闲立马就会被回收。这类线程池适合用于执行定时任务和固定周期的重复任务。
        ExecutorService executorService3 = Executors.newScheduledThreadPool(2);

        eg1:
        System.out.println("造成线程阻塞线程2需等待.........");

//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new testRunnable1());
//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new testRunnable1());
        System.out.println(".........");
        sLock = new ReentrantLock();

//        eg2:
//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sLock.lock();
//                    method3();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    sLock.unlock();
//                }
//            }
//        });
//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sLock.lock();
//                    method3();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    sLock.unlock();
//                }
//            }
//        });

        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
            @Override
            public void run() {
                method1();

            }
        });
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        });
//        eg3:
//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//            @Override
//            public void run() {
//                if (sLock.tryLock()) {
//                    try {
//                        method3();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        sLock.unlock();
//                    }
//                }else {
//                    System.out.println("获取锁失败....222.....");
//                }
//            }
//        });
//        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//            @Override
//            public void run() {
//                if (sLock.tryLock()) {
//                    try {
//                        sLock.lock();
//                        method3();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        sLock.unlock();
//                    }
//                }else {
//                    System.out.println("获取锁失败.........");
//                }
//            }
//        });

//    eg4:
//    ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//        @Override
//        public void run() {
//            method2();
//        }
//    });
//    ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
//        @Override
//        public void run() {
//            method2();
//        }
//    });


        System.out.println(".........");


    }

    private static class testRunnable1 implements Runnable{
        @Override
        public void run() {
            synchronized (this) {//只是当前对象
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName()+" synchronized loop "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void method3(){
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName()+" method3 loop "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void method1(){
        synchronized (A线程01.class) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " method3 loop " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void method2(){
        try {
            sLock.lock();
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+" method3 loop "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){}finally {
            sLock.unlock();
        }

    }
}
