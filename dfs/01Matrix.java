class 01Matrix{

    // Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

    // dfs 25ms
    public int[][] updateMatrix(int[][] m) {
        int row = m.length, col = m[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(m[i][j] != 0) m[i][j] = distance(m, i, j, vis);
            }
        }
        return m;
    }

    private int distance(int[][] m, int i, int j, boolean[][] vis){
        int row = m.length, col = m[0].length;
        if(i < 0 || i >= row || j < 0 || j >= col || vis[i][j] == true ) return 10000;
        if(i - 1 >= 0 && m[i - 1][j] == 0)  return 1;
        if(i + 1 < row && m[i + 1][j] == 0) return 1;
        if(j - 1 >= 0 && m[i][j - 1] == 0)  return 1;
        if(j + 1 < col && m[i][j + 1] == 0) return 1;

        vis[i][j] = true;
        int a = Math.min(distance(m, i + 1, j, vis), distance(m, i - 1, j, vis));
        int b = Math.min(distance(m, i, j + 1, vis), distance(m, i, j - 1, vis));
        vis[i][j] = false;
        return 1 + Math.min(a, b);
    }


}