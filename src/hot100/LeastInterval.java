package hot100;

import java.util.Arrays;

/**
 * @ClassName LeastInterval
 * @Description 任务调度器
 * @Author JH
 * @Date 2019/11/20 15:40
 */
public class LeastInterval {
    public int leastInterval(char[] tasks,int n) {
        if(tasks.length <=1 || n <1) {
            return tasks.length;
        }
        //1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
        int[] counts = new int[26];
        for(int i=0;i<tasks.length;i++) {
            counts[tasks[i]-'A'] ++;
        }
        //2、对数组进行排序，优先排列个数(count)最大的任务
        //如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount-1) * (n+1) +1;
        int i = 24;
        //3、再排序下一个任务，如果下一个任务B个数和最大任务数一致
        //则retCount++ ==> A->B->X->A->B->X->A->B
        while(i >= 0 && counts[i] == maxCount) {
            retCount ++;
            i--;
        }
        //4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
        return Math.max(retCount,tasks.length);
    }
}
