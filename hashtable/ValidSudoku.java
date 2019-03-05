class ValidSudoku{

    // leetcode 36
    // Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated 

    public boolean isValidSudoku(char[][] b) {
        int n = b.length;
        int[][] row = new int[n + 1][n + 1];
        int[][] col = new int[n + 1][n + 1];
        int[][] squ = new int[n + 1][n + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(b[i][j] != '.'){
                    int t = b[i][j] - '0';
                    int k = 3 * (i / 3) + j / 3;
                    row[i][t]++;
                    col[j][t]++;
                    squ[k][t]++;
                    if(row[i][t] > 1 || col[j][t] > 1|| squ[k][t] > 1) return false;
                }
            }
        }
        return true;
    }
}