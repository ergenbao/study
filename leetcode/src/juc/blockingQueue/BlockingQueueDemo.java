package juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author JH
 * 阻塞队列
 **/
public class BlockingQueueDemo {

    public static void main(String[] args) {
        //List list = new ArrayList();
        BlockingQueue<String> blockingQueue =  new ArrayBlockingQueue<String>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
//        blockingQueue.add("d");
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();


    }
}
