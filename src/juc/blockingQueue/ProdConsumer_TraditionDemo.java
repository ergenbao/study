package juc.blockingQueue;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{

    private int num  =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        // 1 判断
        try {
            while (num != 0 ){
                //等待，不能生产
                    condition.await();
            }
            // 2 干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" +num);
            //3 通知 唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        // 1 判断
        try {
            while (num != 1 ){
                //等待，不能生产
                condition.await();
            }
            // 2 干活
            lock.lockInterruptibly();
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" +num);
            //3 通知 唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @Author JH
 * 一个初始值为零的变量，两个线程对其交替操作，一个加一，一个减一，来五轮
 * 线程操作资源类
 * 高内聚  低耦合
 * 判断 干活  通知
 * 防止虚假唤醒机制  要使用while判断
 **/
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"aaa").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"bbb").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"ccc").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"ddd").start();
    }
}
