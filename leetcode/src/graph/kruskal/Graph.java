package graph.kruskal;

import java.util.LinkedList;

/**
 * @Author JH
 **/
public class Graph {
    private int vNum;
    private int edgeNum;
    private LinkedList<Edge>[] edgeLinks;
    private LinkedList<Edge> T;	//入选的边集
    private LinkedList<Integer>[] kindLists;	//用于区分是否形成环

    public Graph(int vNum){
        this.vNum = vNum;
        this.edgeNum = 0;
        edgeLinks = new LinkedList[vNum];
        for(int i = 0;i<vNum;i++){
            edgeLinks[i] = new LinkedList<>();
        }
    }

    public void insertEdge(Edge edge){
        int v1 = edge.getV1();
        int v2 = edge.getV2();
        edgeLinks[v1].add(edge);
        Edge edge2 = new Edge(v2,v1,edge.getWeight());
        edgeLinks[v2].add(edge2);
        edgeNum++;
    }

    public void deleteEdge(Edge edge){
        int v1 = edge.getV1();
        int v2 = edge.getV2();
        edgeLinks[v1].remove(edge);

        for(int i = 0;i<edgeLinks[v2].size();i++){
            Edge edge2 = edgeLinks[v2].get(i);
            if(edge2.equals(edge)){
                edgeLinks[v2].remove(edge2);
                break;
            }
        }
        edgeNum--;
    }

    public void bianli(){
        System.out.println("共有 "+vNum+" 个顶点， "+edgeNum+" 条边。");
        for(int i = 0;i<vNum;i++){
            LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
            System.out.print(i+" : [");
            while(!list.isEmpty()){
                Edge edge = list.pop();
                System.out.print(edge.getV2()+"("+edge.getWeight()+")"+"  ");
            }
            System.out.println("]");
        }
    }

    /**
     * Kruskal算法实现
     */
    public void Kruskal(){

        T = new LinkedList<>();
        kindLists = new LinkedList[vNum];
        for(int i = 0;i<vNum;i++){
            kindLists[i] = new LinkedList<>();
            int num = i;
            kindLists[i].add(num);
        }

        while(edgeNum>0 && T.size()!=vNum-1){
            Edge edge = this.getMinEdge();
            this.deleteEdge(edge);
            int v1 = edge.getV1();
            int v2 = edge.getV2();

            int containsV1 = -1;
            int containsV2 = -1;
            for(int i = 0;i<vNum;i++){
                LinkedList<Integer> list = (LinkedList<Integer>) kindLists[i].clone();
                if(list.contains(v1)){
                    containsV1 = i;
                }
                if(list.contains(v2)){
                    containsV2 = i;
                }
            }

            if(containsV1 != containsV2){
                T.add(edge);
                while(!kindLists[containsV2].isEmpty()){
                    kindLists[containsV1].add(kindLists[containsV2].pop());
                }
            }
        }

        if(T.size() == vNum-1){
            System.out.println("求最小生成树成功");
            int sumWeight = 0;
            LinkedList<Edge> TT = (LinkedList<Edge>) T.clone();
            while(!TT.isEmpty()){
                Edge ee = TT.pop();
                sumWeight += ee.getWeight();
                System.out.println(ee.toString());
            }
            System.out.println("最小生成树权重之和为： "+sumWeight);
        }else{
            System.out.println("没有最小生成树");
        }
    }



    public Edge getMinEdge(){

        Edge minEdge = new Edge(10000);

        for(int i = 0;i<vNum;i++){
            LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
            while(!list.isEmpty()){
                Edge edge = list.pop();
                if(minEdge.getWeight()>edge.getWeight()){
                    minEdge = edge;
                }
            }
        }

        if(minEdge.getWeight()==10000)
            return null;
        return minEdge;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        bookGraph();
        //randomGraph();
    }

    public static void bookGraph(){

        Graph graph = new Graph(9);
        Edge[] edges = new Edge[14];

        edges[0] = new Edge(0,1,4);
        edges[1] = new Edge(0,7,8);
        edges[2] = new Edge(1,2,8);
        edges[3] = new Edge(1,7,11);
        edges[4] = new Edge(2,3,7);
        edges[5] = new Edge(2,5,4);
        edges[6] = new Edge(2,8,2);
        edges[7] = new Edge(3,4,9);
        edges[8] = new Edge(3,5,14);
        edges[9] = new Edge(4,5,10);
        edges[10] = new Edge(5,6,2);
        edges[11] = new Edge(6,7,1);
        edges[12] = new Edge(6,8,6);
        edges[13] = new Edge(7,8,7);

        for(int i = 0;i<14;i++){
            graph.insertEdge(edges[i]);
        }

        graph.bianli();
        graph.Kruskal();
    }


}
