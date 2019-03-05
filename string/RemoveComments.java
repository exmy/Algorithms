class RemoveComments{

    // leetcode 722
    // 删除C++源代码中的注释，包括/* */ 和 // 两种
    // /* */ 如果出现在 // 中可以忽略，反之亦然


    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        
        for(String line: source){
            char[] s = line.toCharArray();
            
            for(int i = 0; i < s.length; i++){
                if(mode){
                    if(s[i] == '*' && i < s.length - 1 && s[i+1] == '/'){
                        mode = false;
                        i++;
                    }
                }else{
                    if(s[i] == '/' && i < s.length - 1 && s[i+1] == '/') break;
                    else if(s[i] == '/' && i < s.length - 1 && s[i+1] == '*'){
                        mode = true;
                        i++;
                    }else sb.append(s[i]);
                }
            }
            
            if(!mode && sb.length() > 0){
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return ans;
    }
}