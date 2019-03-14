class NumberofIslands{

    // leetcode 200
    // Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, i, j, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void dfs(char[][] g, int x, int y, boolean[][] vis){
        if(x < 0 || x >= g.length || y < 0 || y >= g[0].length || vis[x][y] || g[x][y] == '0') return;
        vis[x][y] = true;
        dfs(g, x + 1, y, vis);
        dfs(g, x - 1, y, vis);
        dfs(g, x, y - 1, vis);
        dfs(g, x, y + 1, vis);
    }
}