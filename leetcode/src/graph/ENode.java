package graph;

/**
 * @Author JH
 * @Description 边界点 由一条边和一个终止节点构成
 *
 **/
public class ENode {
    //终止节点的编号
    String id;
    //边的权重
    int weight;

    public ENode(String id) {
        this.id = id;
        this.weight = 1;
    }
}
