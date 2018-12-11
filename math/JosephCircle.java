public class JosephCircle{

    public int josephCircle(int n, int m){
        if(n < 1 || m < 1) return -1;
        int[] a = new int[n];
        int p = -1, count = n, k = 0;
        while (count > 0){
            if(++p == n) p = 0;
            if(a[p] == -1) continue;
            if(++k == m){
                a[p] = -1;
                k = 0;
                count--;
            }
        }
        return p;
    }

    public int josephCircle2(int n, int m){
        if(n < 1 || m < 1) return -1;
        int ans = 0;
        for(int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }

}