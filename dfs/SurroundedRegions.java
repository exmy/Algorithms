class SurroundedRegions{

    // Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
    // A region is captured by flipping all 'O's into 'X's in that surrounded region.
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++){
            check(board, i, 0);
            check(board, i, col - 1);
        }
        for(int j = 1; j < col - 1; j++){
            check(board, 0, j);
            check(board, row - 1, j);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = board[i][j] == '1' ? 'O' : 'X';
            }
        }
    }
    
    private void check(char[][] board, int i, int j){
        int row = board.length, col = board[0].length;
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') return;
        board[i][j] = '1';
        check(board, i + 1, j);
        check(board, i - 1, j);
        check(board, i, j + 1);
        check(board, i, j - 1);
    }
}