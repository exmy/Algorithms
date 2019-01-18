class WordSearch{
    /*
        Given a 2D board and a word, find if the word exists in the grid.
        The word can be constructed from letters of sequentially adjacent cell, 
        where "adjacent" cells are those horizontally or vertically neighboring. 
        The same letter cell may not be used more than once.
    */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int r, int c, char[] w, int k){
        if(k == w.length) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != w[k]) return false;
        board[r][c] ^= 256; // bright point, replace a 'vis' array
        boolean exist = dfs(board, r + 1, c, w, k + 1) ||
                        dfs(board, r - 1, c, w, k + 1) ||
                        dfs(board, r, c + 1, w, k + 1) ||
                        dfs(board, r, c - 1, w, k + 1);
        board[r][c] ^= 256;
        return exist;
    }
}