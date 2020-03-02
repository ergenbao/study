package hot100;

import java.util.LinkedList;

/**
 * @ClassName NumIslands2
 * @Description 岛屿数量  广度优先遍历
 * @Author JH
 * @Date 2019/9/25 18:25
 */
public class NumIslands2 {

    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        rows = grid.length;
        if(rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for(int i = 0 ;i<rows;i++) {
            for(int j= 0;j<cols;j++) {
                //进行广度优先遍历
                if(!marked[i][j] && grid[i][j] == '1') {
                    count ++ ;
                    LinkedList<Integer> queue = new LinkedList<>();
                    //把坐标转换为一个数字
                    queue.addLast(i * cols + j);
                    marked[i][j] = true;
                    while(!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int x = cur / cols;
                        int y = cur % cols;
                        for(int k = 0; k < 4 ;k ++){
                            int nextX = x + directions[k][0];
                            int nextY = y + directions[k][1];
                            if(inArea(nextX,nextY) && !marked[nextX][nextY] && grid[nextX][nextY] == '1') {
                                queue.addLast(nextX * cols + nextY);
                                marked[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inArea(int i,int j) {
        return i>=0 && i<rows && j>=0 && j<cols;
    }


}
