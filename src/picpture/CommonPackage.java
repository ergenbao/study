package picpture;

import java.util.*;

/**
 * @Author: JH
 * @Date: 2019/4/22 9:24
 * 一般背包问题
 */
public class CommonPackage {

    class Body{
        int id; //物体的序号
        int w ; //物体的重量
        int p ; //物体的价值

        public Body(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }

    /**
     * 一般背包问题的代码实现
     * @param w 每个物体重量的数组
     * @param p 每个物体收益的数组
     * @param m 背包数量
     * @return 结果集(放入哪几个物体，每个物体放入多少部分)
     * */
    List<Body> commonPackage(int[] w,int[] p ,int m) {
        //构建物体对象列表（将入参存储在List<Body>中）
        List<Body> bodies = new ArrayList<>();
        for (int i = 0 ; i<w.length; i++) {
            bodies.add(new Body(w[i],p[i]));
        }
        //对性价比进行排列（从高到低进行排序）
        Collections.sort(bodies, new Comparator<Body>() {
            @Override
            public int compare(Body b1, Body b2) {
                return b2.p / b2.w  - b1.p / b1.w;
            }
        });
        //将物体按照性价比从高到低依次加入背包
        int rest = m;
        int i =0;
        List<Body> results = new ArrayList<>();
        for (;i < bodies.size();i++) {
            if(rest < bodies.get(i).w) {
                break;
            }
            Body curBody = bodies.get(i);
            results.add(curBody);
            rest -= curBody.w;
        }

        return results;
    }


}
