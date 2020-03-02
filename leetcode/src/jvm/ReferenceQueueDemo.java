package jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author JH
 **/
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue();
        WeakReference<Object> weakReferenc = new WeakReference<Object>(o1,queue);
        System.out.println(o1);
        System.out.println(weakReferenc.get());
        System.out.println(queue.poll());

        System.out.println("============");

        o1=null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(o1);
        System.out.println(weakReferenc.get());
        System.out.println(queue.poll());
    }

}
