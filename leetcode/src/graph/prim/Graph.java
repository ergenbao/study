package graph.prim;

import java.util.LinkedList;

/**
 * @Author JH
 **/
public class Graph {
    //顶点数
    private int vNum;

    //边的数量
    private int edgeNum;

    //边的集合
    private LinkedList<Edge>[] edgeLinks;

    //已在树中的顶点集
    private LinkedList<Integer> TV;


    //入选的边集
    private LinkedList<Edge> T;


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
        Edge edge2 = new Edge(v2,v1,edge.getWeight());
        edgeLinks[v1].remove(edge);
        edgeLinks[v2].remove(edge2);
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
     * Prim算法实现
     */
    public void Prim(){

        TV = new LinkedList<>();
        T = new LinkedList<>();
        TV.add(0);

        while(edgeNum>0 && T.size()!=vNum-1){
            Edge edge = getMinEdge(TV);
            if(edge==null)
                break;
            this.deleteEdge(edge);
            T.add(edge);
            TV.add(edge.getV2());
        }

        if(T.size()==vNum-1){
            System.out.println("求最小生成树成功");
            LinkedList<Edge> list = (LinkedList<Edge>) T.clone();
            int sumWeight = 0;
            while(!list.isEmpty()){
                Edge edge = list.pop();
                sumWeight += edge.getWeight();
                System.out.println(edge.toString());
            }
            System.out.println("总的权重为： "+sumWeight);
        }else{
            System.out.println("无最小生成树");
        }


    }

    public Edge getMinEdge(LinkedList<Integer> t){

        Edge minEdge = new Edge(10000);
        LinkedList<Integer> tt = (LinkedList<Integer>) t.clone();

        while(!tt.isEmpty()){
            int i = tt.pop();
            LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
            while(!list.isEmpty()){
                Edge edge = list.pop();
                if(minEdge.getWeight()>edge.getWeight() && !t.contains(edge.getV2())){
                    minEdge = edge;
                }
            }
        }

        if(minEdge.getWeight()==10000)
            return null;
        return minEdge;
    }


    public static void main(String[] args) {

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
        graph.Prim();
    }

    /**
     * 100个点，1000条边，权重为1~100的随机数
     */
    public static void randomGraph(){
        Graph graph = new Graph(100);

        for(int i = 0;i<1000;){

            int preV = (int)(Math.random()*100);
            int folV = (int)(Math.random()*100);
            int weight = (int)(Math.random()*100+1);
            if(preV != folV){
                Edge edge = new Edge(preV,folV,weight);
                try{
                    graph.insertEdge(edge);
                    i++;
                }catch(Exception e){
                    continue;
                }
            }
        }

        graph.bianli();
        graph.Prim();
    }







}
