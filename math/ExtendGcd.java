class ExtendGcd{

    // 扩展欧几里得
    // 求解 ax+by=gcd(a,b) 的解x和y
    // 过程
    // 1. 当b=0, gcd(a,b)=a, 此时x=1, y=0
    // 2. 当b>0, 
    // ax1 + by1 = gcd(a, b)
    // bx2 + (a%b)y2 = gcd(b, a%b)
    // => ax1 + by1 = bx2 + (a%b)y2
    // => ax1 + by1 = bx2 + (a-a/b*b)*y2 = bx2 + ay2-a/b*b*y2
    // => ax1 + by1 = ay2 + b(x2-a/b*y2)
    // => x1=y2, y1=x2-a/b*y2

    public int[] extendGcd(int a, int b){
        int[] result = new int[3];
        if(b == 0){
            result[0] = a;
            result[1] = 1;
            result[2] = 0;
            return result;
        }
        int[] tmp = extendGcd(b, a % b);
        result[0] = tmp[0];
        result[1] = tmp[2];
        result[2] = tmp[1] - (a/b)*tmp[2];
        return result;
    }

    // c++
    int extendGcd(int a, int b, int& x, int &y){
        if(b == 0){
            x = 1; y = 0;
            return a;
        }
        int r = extendGcd(b, a % b, x, y);
        int t = x;
        x = y; y = t-a/b*y;
        return r;
    }
}