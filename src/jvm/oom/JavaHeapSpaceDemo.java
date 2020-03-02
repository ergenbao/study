package jvm.oom;

import java.util.Random;

/**
 * @Author JH
 **/
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
        String str = "aaaa";
        while (true) {
            str += str + new Random().nextInt(111111);
            str.intern();
        }
    }
}
