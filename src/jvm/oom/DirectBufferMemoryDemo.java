package jvm.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @Author JH
 **/
public class DirectBufferMemoryDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的maxDirectMemory:"+sun.misc.VM.maxDirectMemory() / (double)1024 / 1024 + "MB");
        TimeUnit.SECONDS.sleep(3);
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

}
