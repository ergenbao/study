package picpture;

import java.util.*;

/**
 * @Author: JH
 * @Date: 2019/4/22 7:37
 */
public class BFS {

    //记录节点是否被访问
    Map<String, Boolean> mark = new HashMap<>();


    /**
     * 图的宽度优先遍历
     * 本函数用于选择未访问的记录
     *
     * @param graph 图的邻接表
     */
    public void BFS(Map<String, List<Enode>> graph) {
        for (String node : graph.keySet()) {
            mark.put(node, false);
        }

        for (String node : graph.keySet()) {
            if (!mark.get(node)) {
                //选择一个起点
                String start = node;
                BFS(graph,start);

            }
        }

    }

    /**
     * 图的宽度优先遍历
     * 本函数用于访问指定节点的路径上的所有节点
     * @param start 起点
     * */
    private void BFS(Map<String, List<Enode>> graph,String start) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            //取出一个节点
            String curNode = queue.poll();
            //访问节点
            System.out.println(curNode);
            //设置为已访问
            mark.put(curNode,true);
            for (Enode enode : graph.get(curNode)) {
                if( !mark.get(enode.id)) {
                    queue.offer(enode.id);
                }
            }
        }

    }
}
