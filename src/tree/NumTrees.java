package tree;


/**
 * @ClassName NumTrees
 * @Description 不同的二叉搜索树
 * @Author JH
 * @Date 2019/11/25 14:14
 */
public class NumTrees {


    //G(n) 长度为n的序列的不同二叉搜索树个数   至于长度有关
    //F(i,n) 以i为根的不同二叉搜索树个数(1 <= i <= n).
    //F(i,n)=G(i−1)⋅G(n−i)
    // G(n)=
    //i=1
    //∑
    //n
    //​
    // G(i−1)⋅G(n−i)
    public int numTrees(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        //i为序列长度
        for(int i = 2;i <= num ;i++ ) {
            //j为当前根节点的角标
            for(int j = 1 ;i <= num ;j++) {
                dp[i]  += dp[i-1] * dp[i-j];
            }
        }
        return dp[num];
    }


}
