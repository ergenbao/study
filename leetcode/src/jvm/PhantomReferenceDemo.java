package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author JH
 **/
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,queue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
        System.out.println("=============");

        o1=null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

    }
}
