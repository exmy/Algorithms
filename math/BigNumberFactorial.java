class BigNumberFactorial{

    // 大数计算阶乘位数
    // lg(N!)=[lg(N*(N-1)*(N-2)*......*3*2*1)]+1 = [lgN+lg(N-1)+lg(N-2)+......+lg3+lg2+lg1]+1;
    int factorialDigit(int n){
        double sum = 0;
        for(int i = 1; i <= n; i++) sum += Math.log10(i);
        return (int)sum + 1;
    }

    public Stiring bigNumberFactorial(int n){
        int[] ans = new int[100001];
        int digit = 1;
        ans[0] = 1;
        for(int i = 1; i <= n; i++){
            int num = 0;
            for(int j = 0; j < digit; j++){
                int t = ans[j] * i + num;
                ans[j] = t % 10;
                num = t / 10;
            }
            while(num != 0){
                ans[digit++] = num % 10;
                num /= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = digit - 1; i >= 0; i--) sb.append((char)(ans[i] + '0'));
        return sb.toString();
    }
}