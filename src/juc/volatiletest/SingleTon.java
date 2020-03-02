package juc.volatiletest;

/**
 * @Author JH
 **/
public class SingleTon {

    public static volatile SingleTon instance = null;

    private SingleTon(){
        System.out.println(Thread.currentThread().getName() +"我是私有构造方法");
    }
    //dcl(doubble check lock 双端检索机制)
    public static SingleTon getInstance(){
        if(null == instance) {
            synchronized (SingleTon.class){
                if(null == instance) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i <200 ; i++) {
            new Thread(()->{
                SingleTon.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
