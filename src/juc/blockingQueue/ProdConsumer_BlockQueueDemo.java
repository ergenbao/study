package juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author JH
 **/
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        MyResource resource = new MyResource(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t启动");
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t启动");
            try {
                resource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("要结束了");
        resource.stop();

    }
}

class MyResource{
    private volatile boolean flag = true; //默认开启 生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean reValue ;
               while (flag) {
                  data =  atomicInteger.incrementAndGet()+ "";
                  reValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
                  if(reValue) {
                      System.out.println(Thread.currentThread().getName() + "\t插入队列"+data+"成功" );
                  }else {
                      System.out.println(Thread.currentThread().getName() + "\t插入队列"+data+"失败" );

                  }
                   TimeUnit.SECONDS.sleep(1);
               }
        System.out.println("大老板叫停flag==false");
    }
    public void myConsumer()throws Exception{
        String result ;
        while (flag) {
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || "".equals(result)){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t超过两秒没有收到蛋糕，消费退出");
                return;

            }
            System.out.println(Thread.currentThread().getName() + "\t移除队列"+result+"成功" );

        }
    }

    public void stop() {
        this.flag = false;
    }
}
