package hot100;

import java.util.LinkedList;

/**
 * @ClassName CanFinish
 * @Description 课程表
 * @Author JH
 * @Date 2019/9/26 17:29
 */
public class CanFinish {
        public boolean canFinish(int numCourses,int[][] prerequisites) {
            int [] indegrees = new int[numCourses];
            for(int [] cp : prerequisites) {
                indegrees[cp[0]] ++;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for(int i = 0;i<numCourses;i++) {
                if(indegrees[i] == 0){
                    queue.addLast(i);
                }
            }
            while (!queue.isEmpty()) {
                Integer pre  = queue.removeFirst();
                numCourses--;
                for(int[] req :prerequisites) {
                    if(req[1] != pre) {
                        continue;
                    }
                    if(--indegrees[req[0]] == 0) {
                        queue.add(req[0]);
                    }
                }
            }
            return numCourses == 0;
        }
}
