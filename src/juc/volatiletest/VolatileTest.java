package juc.volatiletest;

/**
 * @Author JH
 **/
class Test{
    volatile int num = 0;
    //测试可见性
    void changeTo60(){
        num = 60;
    }
    void addPlusPlus(){
        num ++ ;
    }
}
/**
 * volatile可以保证可见性
 * */
public class VolatileTest {
    public static void main(String[] args) {
        Test test = new Test();

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName() + "com in"
//            );
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            test.changeTo60();
//      },"aaa").start();
//        while(test.num == 0){
//
//        }
//        System.out.println("num:"+test.num);

        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    test.addPlusPlus();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(test.num);
    }


}

