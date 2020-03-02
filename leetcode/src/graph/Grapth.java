package graph;

import org.junit.Test;

import java.util.*;

/**
 * @Author JH
 * 图的邻接表
 **/
public class Grapth {



    public void bfs(Map<String,List<ENode>> graph) {
        //用于记录节点访问情况
        Map<String,Boolean> mark = new HashMap<>();

        for (String id: graph.keySet()) {
            mark.put(id,false);
        }
        for (String node : graph.keySet()) {
            bfs(graph,node,mark);
        }
    }
    /**
     * BFS
     * 相当于二叉树的层次遍历
     * */
    public void bfs(Map<String,List<ENode>> graph ,String node, Map<String,Boolean> mark) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            String id = queue.poll();
            System.out.println(id);
            mark.put(id,true);
            for (ENode e  : graph.get(id)){
                    if(!mark.get(e.id)){
                        queue.offer(e.id);
                    }
            }
        }
    }

    public void dfs(Map<String,List<ENode>> graph) {
        //用于记录节点访问情况
        Map<String,Boolean> mark = new HashMap<>();
        for (String id: graph.keySet()) {
            mark.put(id,false);
        }
        for (String node : graph.keySet()) {
            dfs(graph,node,mark);
        }
    }


    public void dfs(Map<String,List<ENode>> graph ,String start, Map<String,Boolean> mark) {
            mark.put(start,true) ;
        System.out.println(start);
            if(graph.containsKey(start)){
                for (ENode e :graph.get(start)) {
                    if (!mark.getOrDefault(e.id,false)) {
                        dfs(graph,e.id,mark);
                    }
                }
            }

    }

    @Test
   public void test() {
        Map<String,List<ENode>> graph = new HashMap<>();
       List<ENode> a_list = new ArrayList<>();
       a_list.add(new ENode("b"));
       a_list.add(new ENode("c"));
        graph.put("a",a_list);
        dfs(graph);
   }


}
