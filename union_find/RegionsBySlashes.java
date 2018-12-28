public class RegionsBySlashes{
    int n;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        DSU dsu = new DSU(4 * n * n);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; j++){
                int root = 4 * (i * n + j);
                char val = grid[i].charAt(j);
                if(i > 0) dsu.union(g(i - 1, j, 2), g(i, j, 0));
                if(j > 0) dsu.union(g(i, j - 1, 1), g(i, j, 3));
                if(val != '/'){
                    dsu.union(g(i, j, 0), g(i, j, 1));
                    dsu.union(g(i, j, 2), g(i, j, 3));
                }
                if(val != '\\'){
                    dsu.union(g(i, j, 0), g(i, j, 3));
                    dsu.union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return dsu.ans;
    }
    
    private int g(int i, int j, int k){
        return 4 * (i * n + j) + k;
    }
}

class DSU{
    int[] p;
    int ans;
    public DSU(int n){
        p = new int[n];
        ans = n;
        for(int i = 0; i < n; i++) p[i] = i;
    }
    public int find(int x){
        return x != p[x] ? p[x] = find(p[x]) : x;
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            p[x] = y;
            ans--;
        }
    }
}