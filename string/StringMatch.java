class StringMatch{

    // sunday algorithm
    public int match(char[] s, char[] p){
        int[] move = new int[128];

        for(int i = 0; i < 128; i++) move[i] = p.length + 1;
        for(int i = 0; i < p.length; i++) move[p[i]] = p.length - i;
        int i = 0, j = 0;
        while(i <= s.length - p.length){
            j = 0;
            while(s[i+j] == p[j]){
                j++;
                if(j >= p.length) return i;
            }
            i += move[s[i+p.length]];
        }
        return -1;
    }

}