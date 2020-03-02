package jvm;

import java.lang.ref.SoftReference;

/**
 * @Author JH
 **/
public class SoftReferenceDemo {

    /**
     * 故意创建大对象，分配小内存
     * */
    public static void softRef_Memory_NotEnough(){
        Object o1 =new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 =null;

        try {
            byte[] bytes = new byte[30*1024*1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }
    public static void softRef_Memory_Enough(){
        Object o1 =new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 =null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
