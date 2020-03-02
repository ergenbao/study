package juc.locktest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author JH
 * 集齐龙珠、召唤神龙
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("*****召唤神龙");
        });

        for (int i = 1; i <8 ; i++) {
            final int tempi = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "\t收集到第"+tempi +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
