class AdditiveNumber{
    
    public boolean isAdditiveNumber(String s) {
        int n = s.length();
        for(int i = 1; i < n; i++){
            long a = parse(s.substring(0, i));
            for(int j = i + 1; j < n; j++){
                long b = parse(s.substring(i, j));
                if(a == -1 || b == -1) continue;
                if(dfs(s.substring(j), a, b)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(String s, long a, long b){
        if(s.length() == 0) return true;
        for(int i = 1; i <= s.length(); i++){
            long c = parse(s.substring(0, i));
            if(c - b == a && dfs(s.substring(i), b, c)) return true;
        }
        return false;
    }
    
    private long parse(String s){
        if(s.startsWith("0") && !s.equals("0")) return -1;
        long result = 0;
        try{
            result = Long.parseLong(s);
        }catch(NumberFormatException e){
            return -1;
        }
        return result;
    }
}