class NQueens{

    // leetcode 51
    // The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    // way 1: 逐行放置
    private boolean[][] vis;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        List<List<String>> ans = new ArrayList<>();
        dfs(board, 0, ans);
        return ans;
    }
    
    private void dfs(char[][] board, int row, List<List<String>> ans){
        if(row == board.length){
            ans.add(f(board));
            return;
        }
        // 在第row行的第i列放置皇后
        for(int i = 0; i < board.length; i++){
            // if(validate(board, row, i)){
            //     board[row][i] = 'Q';
            //     dfs(board, row + 1, ans);
            //     board[row][i] = '.';
            // }
            // 优化
            // x+y标识副对角线，y-x标识主对角线
            if(!vis[0][i] && !vis[1][row+i] && !vis[2][row-i+board.length]){
                board[row][i] = 'Q';
                // 第i列    副对角线         主对角线
                vis[0][i] = vis[1][row+i] = vis[2][row-i+board.length] = true;
                dfs(board, row + 1, ans);
                board[row][i] = '.';
                vis[0][i] = vis[1][row+i] = vis[2][row-i+board.length] = false;
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < board.length; j++)
                // 检查纵向和斜向
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || y == j)) return false;
        }
        return true;
    }
    
    private List<String> f(char[][] board){
        List<String> s = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            s.add(new String(board[i]));
        }
        return s;
    }
}