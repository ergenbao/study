package hot100;

/**
 * @ClassName NumsTrees
 * @Description 不同的二叉搜索树
 * @Author JH
 * @Date 2019/9/11 10:47
 */
public class NumsTrees {
    public int numsTrees(int n) {
        int [] G = new int[n+1];
        G[0] =1 ;
        G[1] = 1;
        for(int i = 2 ;i < n+1;i++) {
            for (int j = 0;j<i;j++) {
                G[i] += G[j] *G[i-j-1];
            }
        }
        return G[n];
    }
}
