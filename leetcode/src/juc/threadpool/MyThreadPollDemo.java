package juc.threadpool;


import java.util.concurrent.*;

/**
 * @Author JH
 * 第四种使用java多线程的方式、线程池
 **/
public class MyThreadPollDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ThreadPoolExecutor pool = new ThreadPoolExecutor()
        // Executor Executors(辅助工具类)
        //一池5个处理线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy() );
        try {
            for (int i = 0; i <50 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
//                TimeUnit.SECONDS.sleep(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
