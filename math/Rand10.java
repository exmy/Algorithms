class Rand10{

    // leetcode 470. Given a function rand7 which generates a uniform random integer in the range 1 to 7, 
    // write a function rand10 which generates a uniform random integer in the range 1 to 10.

    // Implement rand10() using rand7()
    public int rand10() {
        int row, col, idx;
        do{
            row = rand7() - 1;
            col = rand7() - 1;
            idx = 7 * row + col;
        }while(idx > 40);
        return idx % 10 + 1;
    }

    // Implement randN() using rand2()
    // rand2() generates 0 or 1
    public int randN(int n){
        int p = 1;
        while((1 << p) < n) p++;
        int[] a = new int[p];
        int idx = 0;
        do{
            idx = 0;
            int t = 1;
            for(int i = p - 1; i >= 0; i--){
                a[i] = rand2() * t;
                t <<= 1;
                idx += a[i];
            }
        }while(idx > n);
        return idx % n + 1;
    }
}