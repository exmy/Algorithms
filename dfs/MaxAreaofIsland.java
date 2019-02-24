class MaxAreaofIsland{

    // leetcode 695
    // Given a non-empty 2D array grid of 0's and 1's, 
    // an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
    // You may assume all four edges of the grid are surrounded by water.
    // Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

    /* input: 
        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,1,1,0,1,0,0,0,0,0,0,0,0],
         [0,1,0,0,1,1,0,0,1,0,1,0,0],
         [0,1,0,0,1,1,0,0,1,1,1,0,0],
         [0,0,0,0,0,0,0,0,0,0,1,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,0,0,0,0,0,0,1,1,0,0,0,0]]
        output:
            6
    */

    int[][] g;
    boolean[][] vis;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.g = grid;
        int r = g.length, c = g[0].length;
        vis = new boolean[r][c];
        
        int ans = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                ans = Math.max(ans, area(i, j));
            }
        }
        return ans;
    }
    
    private int area(int i, int j){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length || vis[i][j] || g[i][j] == 0) return 0;
        
        vis[i][j] = true;
        return 1 + area(i + 1, j) + area(i - 1, j) + area(i, j + 1) + area(i, j - 1);
    }


}