public class MovingCount{

    public int movingCount(int k, int rows, int cols){
        boolean[] vis = new boolean[rows * cols];
        return dfs(k, rows, cols, 0, 0, vis);
    }
    
    private int dfs(int k, int rows, int cols, int r, int c, boolean[] vis){
        if(!check(k, rows, cols, r, c, vis)) return 0;
        vis[r * cols + c] = true;
        return 1 + dfs(k, rows, cols, r, c + 1, vis) + 
                   dfs(k, rows, cols, r, c - 1, vis) + 
                   dfs(k, rows, cols, r + 1, c, vis) + 
                   dfs(k, rows, cols, r - 1, c, vis);
    }
    
    private boolean check(int k, int rows, int cols, int r, int c, boolean[] vis){
        if(r >= 0 && r < rows && c >= 0 && c < cols && !vis[r * cols + c] && 
          digitSum(r) + digitSum(c) <= k) return true;
        return false;
    }
    
    private int digitSum(int n){
        int ret = 0;
        while(n > 0){
            ret += n % 10;
            n /= 10;
        }
        return ret;
    }
    
}