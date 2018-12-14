public class ParseInt{

    // Integer.parseInt()
    public int parseInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int result = 0;
        boolean neg = false;
        int i = 0, n = s.length();
        int radix = 10;
        int limit = -Integer.MAX_VALUE;
        int multmin;

        char firstChar = s.charAt(0);
        if(!Character.isDigit(firstChar)){
            if(firstChar == '-'){
                neg = true;
                limit = Integer.MIN_VALUE;
            }else if(firstChar != '+') return 0;

            if(n == 1) return 0;
            i++;
        }
        multmin = limit / radix;
        while(i < n){
            int digit = Character.digit(s.charAt(i++), radix);
            if(digit < 0 || result < multmin) return 0;
            result *= radix;
            if(result < limit + digit) return 0;
            result -= digit;
        }

        return neg ? result : -result;
    }

    public int parseInt2(String s){
        if(s == null || s.isEmpty()) return 0;
        int neg = 1, n = s.length();
        long res = 0;
        char firstChar = s.charAt(0);
        if(firstChar == '-') neg = -1;
        for(int i = (firstChar == '-' || firstChar == '+') ? 1 : 0; i < n; i++){
            if(!Character.isDigit(s.charAt(i))) return 0;
            res = (res << 1) + (res << 3) + (s.charAt(i) & 0xf);
            if(neg == 1 && res > Integer.MAX_VALUE) return 0;
            if(neg ==-1 && res > (long)Integer.MAX_VALUE + 1) return 0;
        }

        return (int)res * neg;
    }

}