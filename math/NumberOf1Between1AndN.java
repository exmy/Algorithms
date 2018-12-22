public class NumberOf1Between1AndN{

    public int numberOf1Between1AndN(int n) {
        int ans = 0;
        long i = 1;
        for(; i <= (long)n; i *= 10){
            long a = n / i, b = n % i;
            long t = (a % 10 == 1) ? 1 : 0;
            ans += (a + 8) / 10 * i + t * (b + 1);
        }
        return ans;
    }

}