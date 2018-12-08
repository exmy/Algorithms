public class UglyNumber{
    
    public int getUglyNumber(int n) {
        if(n == 0) return 0;
        int[] a = new int[n];
        a[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++){
            a[i] = min(a[p2] * 2, a[p3] * 3, a[p5] * 5);
            while(a[p2] * 2 <= a[i]) p2++;
            while(a[p3] * 3 <= a[i]) p3++;
            while(a[p5] * 5 <= a[i]) p5++;
        }
        return a[n - 1];
    }
    
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}