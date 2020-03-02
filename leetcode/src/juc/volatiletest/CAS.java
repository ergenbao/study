package juc.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author JH
 **/
public class CAS {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5,2019);
        atomicInteger.getAndIncrement();
    }

}
