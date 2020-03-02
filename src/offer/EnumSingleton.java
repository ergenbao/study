package offer;


import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author: JH
 * @Date: 2019/4/23 11:34
 * 单例模式
 */
public class EnumSingleton {

    private EnumSingleton(){}
    public static EnumSingleton getInstance() {
        return SingleTon.Instance.getInstance();
    }

    private static enum SingleTon{
        Instance;
        private EnumSingleton singleton;
        private SingleTon() {
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance() {
            return singleton;
        }
    }

}
