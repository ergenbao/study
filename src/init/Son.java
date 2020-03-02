package init;

/**
 * @Author JH
 * 子类
 **/
public class Son  extends Parent{

    private int age = 10;

    public Son() {
        System.out.println("子类构造函数");
    }
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println(age);
        System.out.println("子类代码块");
        age = 15;
    }

    public static void main(String[] args) {
        System.out.println(new Son().age);
    }


}
