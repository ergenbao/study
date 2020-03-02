package jvm;


import java.util.concurrent.TimeUnit;

/**
 * @Author JH
 **/
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("****helloGc");
        byte[] bytes = new byte[5*1024*1024*1024];
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
