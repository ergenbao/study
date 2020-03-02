package juc.locktest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author JH
 **/
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i <5 ; i++) {
            final  int tempi = i;
            new Thread(() -> {
                cache.put(tempi+"",tempi);
            },String .valueOf(tempi)).start();
        }
        for (int i = 0; i <5 ; i++) {
            final  int tempi = i;
            new Thread(() -> {
                 cache.get(tempi+"");
            },String .valueOf(tempi)).start();
        }
    }

}
/**
 * 资源类
 *
 * */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key , Object value) {
        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入" + key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }



    }


    public void get(String key) {

        rwLock.readLock().lock();


        try {

            System.out.println(Thread.currentThread().getName() + "\t 正在读取" );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }

    }
}
