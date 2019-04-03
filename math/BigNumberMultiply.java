class BigNumberMultiply{

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

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}