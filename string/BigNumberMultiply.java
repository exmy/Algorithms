class BigNumberMultiply{

    // 模拟手算
    public int[] multiply(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                c[i + j + 1] += a[i] * b[j];
            }
        }

        for(int i = c.length - 1; i > 0; i--){
            if(c[i] >= 10){
                c[i - 1] += c[i] / 10;
                c[i] %= 10;
            }
        }
        if(c[0] == 0){
            int[] d = new int[c.length - 1];
            System.arraycopy(c, 1, d, 0, c.length - 1);
            c = d;
        }

        return c;
    }
}