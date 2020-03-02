package offer;

import java.util.LinkedList;

/**
 * @Author JH
 * 圆圈中最后剩下的数字
 **/
public class LastRemaining {

    public int solution(int n, int m) {
        if (n <1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i= 1;i <= n;i++) {
            list.push(i);
        }

        int index = 0;

        while (list.size()>1) {
            index = (index+m-1) % list.size();
            list.remove(index);
        }

        return list.size()==1 ? list.get(0):-1;


    }

}
