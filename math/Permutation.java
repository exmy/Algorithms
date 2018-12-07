public class Permutation{

    public ArrayList<String> permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str == null || str.isEmpty()) return ans;
        permutation(str.toCharArray(), 0, ans);
        Collections.sort(ans);
        return ans;
    }

    private void permutationHelper(char[] str, int i, ArrayList<String> ans){
        if(i == str.length - 1){
            ans.add(String.valueOf(str));
            return;
        }
        for(int k = i; k < str.length; k++){
            if(check(str, i, k)) continue;
            swap(str, i, k);
            permutationHelper(str, i + 1, ans);
            swap(str, i, k);
        }
    }
    
    // 去重
    private boolean check(char[] s, int l, int k){
        for(int i = l; i < k; i++){
            if(s[i] == s[k]) return true;
        }
        return false;
    }

    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}