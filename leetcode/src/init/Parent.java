package init;

/**
 * @Author JH
 * 父类
 **/
public class Parent {

    static {
        System.out.println("父类静态代码块");
    }

    public Parent() {
        System.out.println("父构造器");
    }

    {
        System.out.println("父代码块");
    }

}
