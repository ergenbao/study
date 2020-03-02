package hot100;

/**
 * @ClassName NumIslands
 * @Description 岛屿数量  深度优先遍历
 * @Author JH
 * @Date 2019/9/25 16:21
 */
public class NumIslands {

    //方向数组  上 右 下 左
    private static final int[][] DIRECTIONS = {{-1,0},{0,1},{1,0},{0,-1}};
    //标记数组，标记格子的坐标是否被访问过
    private boolean[][] marked;
    //行数
    private int rows;
    //列数
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if(rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                //如果是岛屿中的一个点，并且没有被访问过
                //进行深度优先遍历
                if(!marked[i][j] && grid[i][j] == '1') {
                    count ++;
                    dfs(i,j);
                }
            }
        }
        return count;
    }
    //从坐标为(i,j)的点开始进行深度优先遍历
    private void dfs(int i ,int j) {
        marked[i][j] = true;
        //得到四个方向的坐标
        for(int k = 0 ;k<4;k++) {
            int x = i+DIRECTIONS[k][0];
            int y = j + DIRECTIONS[k][1];
            //如果在范围内，且是陆地，并且没有被访问过
            if(inArea(x,y) && grid[x][y] == '1' && !marked[x][y]) {
                dfs(x,y);
            }
        }
    }

    private boolean inArea(int x,int y) {
        return  x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
