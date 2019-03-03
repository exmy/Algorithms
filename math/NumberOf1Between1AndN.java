public class NumberOf1Between1AndN{

    // 从1到n整数中1出现的次数

    // 从个位、十位、百位....考察每个位中1出现的次数
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