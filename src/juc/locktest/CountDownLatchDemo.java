package juc.locktest;



import juc.Year;

import java.util.concurrent.CountDownLatch;

/**
 * @Author JH
 **/
public class CountDownLatchDemo {

     CountDownLatch countDownLatch = new CountDownLatch(4);
    @org.junit.Test
   public  void test() throws InterruptedException {
        for (int i = 1; i <5 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "来了");
                countDownLatch.countDown();
            }, Year.get(i)).start();
        }
        countDownLatch.await();
        System.out.println("i am coming");
   }


}
