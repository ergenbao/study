package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JH
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 **/
public class GCOverHeadDemo {

    public static void main(String[] args) {
        int i = 0 ;
        List<String> list = new ArrayList<>();

        try {
            while(true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("i:  "+i);
            e.printStackTrace();
            throw e;
        } finally {
        }
    }
}
