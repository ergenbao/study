package picpture;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: JH
 * @Date: 2019/4/22 7:24
 * 边节点，由一条边和一个终止节点组成
 */
public class Enode {
    /**终止节点的编号*/
    String id ;
    int weight;

    /**一张图可以这么表示
     * Integer表示节点编号
     * List中装的是一个个终止节点
     * */
//    Map<Integer,List<Enode>> map;
    List list = new CopyOnWriteArrayList();
    List list1 = new Vector();
    Map map = new HashMap();
    Map map1= new LinkedHashMap();

    public static void main(String[] args) {
        Stack stack = new Stack();
        Map map3 = new ConcurrentHashMap();
    }

}
