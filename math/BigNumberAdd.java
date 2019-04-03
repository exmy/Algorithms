class BigNumberAdd{

    public String add(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n = s1.length, m = s2.length;
        int l = Math.max(n, m);
        int[] a = new int[l+1];
        int[] b = new int[l+1];
        for(int i = 0; i < n; i++) a[i] = s1[n-i-1] - '0';
        for(int i = 0; i < m; i++) b[i] = s2[m-i-1] - '0';
        for(int i = 0; i < l; i++){
            if(a[i] + b[i] >= 10){
                int t = a[i] + b[i];
                a[i] = t % 10;
                a[i+1] += t / 10;
            }else a[i] += b[i];
        }
        StringBuilder sb = new StringBuilder();
        if(a[l] != 0) sb.append((char)(a[l] + '0'));
        for(int i = l-1; i >= 0; i--) sb.append((char)(a[i] + '0'));
        return sb.toString();
    }
}