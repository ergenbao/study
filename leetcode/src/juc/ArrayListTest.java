package juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author JH
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list = new CopyOnWriteArrayList();
        Set set = new HashSet();
        Map map = new HashMap();
    }
}
