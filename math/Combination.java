public class Combination{

    public ArrayList<String> combination(String str){
        ArrayList<String> ans = new ArrayList<>();

        return getSubset(str);
    }

    private ArrayList<String> getSubset(String str){
        ArrayList<String> ans = new ArrayList<>();
        int n = str.length();
        String s = "";
        for(int i = 0; i < (1 << n); i++){
            s = "";
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    s += str.charAt(j);
                }
            }
            ans.add(s);
        }
        return ans;
    }
    
}