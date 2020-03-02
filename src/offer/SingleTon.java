package offer;



/**
 * @Author: JH
 * @Date: 2019/4/23 12:38
 * 静态内部类实现单例
 */
public class SingleTon {

    private SingleTon(){}

//    public static SingleTon getInstance() {
//        return Inner.INSTANCE;
//    }
//
//    private static class Inner{
//       private static final SingleTon INSTANCE = new SingleTon();
//    }
    public static volatile SingleTon INSTANCE = null;

    public static SingleTon getINSTANCE() {
        if(INSTANCE == null) {
            synchronized (SingleTon.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTon();
                }
            }
        }
        return INSTANCE;
    }

}
