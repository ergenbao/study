package hot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName ReconstructQueue
 * @Description 根据身高重建队列
 * @Author JH
 * @Date 2019/11/13 10:29
 */
public class ReconstructQueue {
    //先按h降序、k升序排序
    public int[][] reconstrucQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> a[0] == b[0] ? a[1]-b[1] :b[0] -a[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] i : people) {
            list.add(i[1],i);
        }

        return list.toArray(new int[list.size()][]);
    }
}
