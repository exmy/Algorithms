public class PrintMatrix{

    // print matrix clockwisely
    public ArrayList<Integer> printMatrix(int [][] m) {
       if(m == null ) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        int r = m.length, c = m[0].length;
        int i = 0, j = 0;
        while(i < r && j < c){
            printCircle(m, ans, i, j, r, c);
            i++; j++;
            r--; c--;
        }
        return ans;
    }
    
    private void printCircle(int[][]m, ArrayList<Integer> ans, int ki, int kj, int kr, int kc){
        int i = ki, j = kj;
        for(; j < kc; ++j) ans.add(m[i][j]);
        --j;
        for(i++; i < kr; i++) ans.add(m[i][j]);
        --i;
        for(j--; j >= kj && i != ki; --j) ans.add(m[i][j]);
        ++j;
        for(i--; i > ki && j != kc - 1; --i) ans.add(m[i][j]);
    }
}