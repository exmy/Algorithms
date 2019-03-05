class FactorialTrailingZeroes{

    // Given an integer n, return the number of trailing zeroes in n!.

    // 末尾0 都是由 5 * 2得来
    // 只要计算因数5的个数，因为因数2的个数总是足够的
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}