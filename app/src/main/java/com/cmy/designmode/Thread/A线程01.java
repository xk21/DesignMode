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
    private static ReentrantLock sLock2;

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
        //当前内部内this锁不能全局锁对象不一样
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new testRunnable1());
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new testRunnable1());
        System.out.println(".........");
        sLock = new ReentrantLock();
        sLock2 = new ReentrantLock();

        eg2:
        //通用锁sLock 方法一
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
        eg3:
        //sLock.tryLock(1,TimeUnit.SECONDS) sLock没有规定释放为false否则则为true
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
            @Override
            public void run() {
                if (sLock.tryLock()) {
                    try {
                        method3();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        sLock.unlock();
                    }
                }else {
                    System.out.println("获取锁失败....222.....");
                }
            }
        });
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (sLock.tryLock(1,TimeUnit.SECONDS)){

                    }else {
                        return;
                    }
                        try {
                            method3();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            sLock.unlock();
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//    eg4:
        //通用锁sLock
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

        eg5:
        //两个线程依次打印"A""B",总共打印10次
        new Thread(new Produce()).start();
        new Thread(new Produce2()).start();

        //ReentrantLock循序输出A,B,C
        ConditionService service = new ConditionService();
        Runnable A = getThreadA(service);
        Runnable B = getThreadB(service);
        Runnable C = getThreadC(service);

        new Thread(A, "A").start();
        new Thread(B, "B").start();
        new Thread(C, "C").start();

        System.out.println(".........");


    }



    private static class testRunnable1 implements Runnable{
        @Override
        public void run() {
            synchronized (this) {//只是当前对象
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName()+" testRunnable1 loop "+i);
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
                Thread.sleep(110);
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
                    System.out.println(Thread.currentThread().getName() + " method1 loop " + i);
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
                    System.out.println(Thread.currentThread().getName()+" method2 loop "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){}finally {
            sLock.unlock();
        }

    }


    //循序打印
    public static class Produce2 implements Runnable {

        @Override
        public void run() {
            int count =10;
            while (count>0){
                synchronized (A线程01.class){
                    System.out.println("B");
                    count--;
                    A线程01.class.notifyAll();
                    try {
                        A线程01.class.wait();
                    }catch (Exception e){

                    }
                }
            }
        }
    }


    public static class Produce implements Runnable {
        @Override
        public void run() {
            int count =10;
            while (count>0){
                synchronized (A线程01.class){
                    System.out.println("A");
                    count--;
                    A线程01.class.notifyAll();
                    try {
                        A线程01.class.wait();
                    }catch (Exception e){

                    }
                }
            }
        }

    }

    private static Runnable getThreadA(final ConditionService service) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    service.excuteA();
                }
            }
        };
    }

    private static Runnable getThreadB(final ConditionService service) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    service.excuteB();
                }
            }
        };
    }

    private static Runnable getThreadC(final ConditionService service) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++) {
                    service.excuteC();
                }
            }
        };
    }

}
