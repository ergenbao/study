package picpture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: JH
 * @Date: 2019/4/22 9:11
 * 图的深度优先遍历
 */
public class DFS {


    Map<String,Boolean> mark = new HashMap<>();

    public void DFS(Map<String,List<Enode>> graph) {
        //记录图中节点是否被访问
        for (String node : graph.keySet()) {
            mark.put(node,false);
        }

        for(String node : graph.keySet()) {
            if(!mark.get(node)) {
                String start = node;
                DFS(graph,start);
            }
        }
    }

    private void DFS(Map<String,List<Enode>> graph,String start) {
        System.out.println(start);
        mark.put(start,true);
        List<Enode> enodes = graph.get(start);
        for (Enode enode : enodes) {
            if (!mark.get(enode.id)) {
                DFS(graph,enode.id);
            }
        }

    }

}
