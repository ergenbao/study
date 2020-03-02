package juc.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author JH
 * 实现多个线程之间按顺序调用，A->B->三个线程启动，要求如下：
 *  aa打印5次，bb打印10次，cc打印15次
 **/
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        SharreResource sharreResource = new SharreResource();
        new Thread(() -> {
            for (int i = 0; i <11 ; i++) {
                sharreResource.print5();
            }
        },"a").start();
        new Thread(() -> {
            for (int i = 0; i <11 ; i++) {
                sharreResource.print10();
            }
        },"b").start();
        new Thread(() -> {
            for (int i = 0; i <11 ; i++) {
                sharreResource.print20();
            }
        },"c").start();
    }
}

class SharreResource{
    private int num  = 1 ;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5(){
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            for (int i = 1; i <6 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t" +i);
            }
            num = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (num != 2) {
                c2.await();
            }
            for (int i = 1; i <11 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t" +i);
            }
            num = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print20(){
        lock.lock();
        try {
            while (num != 3) {
                c3.await();
            }
            for (int i = 1; i <21 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t" +i);
            }
            num = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

