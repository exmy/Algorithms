public class PathInMatrix{

    boolean[] vis = null;
    public boolean hasPath(char[] m, int rows, int cols, char[] s){
        if(m == null || rows < 1 || cols < 1 || s == null) return false;
        vis = new boolean[rows * cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(hasPath(m, rows, cols, r, c, 0, s)) return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[] m, int rows, int cols, int r, int c, int i, char[] s){
        if(i >= s.length) return true;
        int pos = r * cols + c;
        if(r < 0 || r >= rows || c < 0 || c >= cols || vis[pos] || s[i] != m[pos]) return false;

        vis[pos] = true;
        boolean haspath = hasPath(m, rows, cols, r, c + 1, i + 1, s) ||
                hasPath(m, rows, cols, r, c - 1, i + 1, s) ||
                hasPath(m, rows, cols, r + 1, c, i + 1, s) ||
                hasPath(m, rows, cols, r - 1, c, i + 1, s);
        if(!haspath) vis[pos] = false;

        return haspath;
    }


}