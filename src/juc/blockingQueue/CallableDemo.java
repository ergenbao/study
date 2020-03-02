package juc.blockingQueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author JH
 **/
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       FutureTask<String> future = new FutureTask<String>(new MyThread());
       Thread thread = new Thread(future,"aaa");
       thread.start();
        System.out.println(future.get());
    }

}
class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
}
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("hi");
        return "123";
    }
}
