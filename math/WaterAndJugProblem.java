class WaterAndJugProblem{

    // leetcode 365
    // 一个容量x升的水桶，一个容量y升的水桶，是否可以倒出z升的水

    // 裴蜀定理：对于非零整数a,b, 以及a、b的最大公约数d，存在整数x和y，使得ax+by=d

    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        // ax+by=nd=z
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}