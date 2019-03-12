class NQueensII{

    // leetcode 52
    // The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    // Given an integer n, return the number of distinct solutions to the n-queens puzzle.

    int ans = 0;
    int[] pos;
    boolean[][] vis;
    
    public int totalNQueens(int n) {
        pos = new int[n];
        vis = new boolean[3][2*n];
        dfs(0, n);
        return ans;
    }
    
    private void dfs(int row, int n){
        if(row == n){
            ans++;
            return;
        }
        for(int i = 0; i < n; i++){
            // pos[row] = i + 1;
            // if(validate(row)) dfs(row + 1, n);
            if(!vis[0][i] && !vis[1][row+i] && !vis[2][row-i+n]){
                pos[row] = i + 1;
                vis[0][i] = vis[1][row+i] = vis[2][row-i+n] = true;
                dfs(row + 1, n);
                vis[0][i] = vis[1][row+i] = vis[2][row-i+n] = false;
            }
        }
    }
    
    private boolean validate(int row){
        for(int i = 0; i < row; i++){
            if(Math.abs(pos[i] - pos[row]) == Math.abs(i - row) || pos[i] == pos[row]) return false;
        }
        return true;
    }
    
}