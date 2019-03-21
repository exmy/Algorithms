class RemoveKDigits{

    // leetcode 402
    // Given a non-negative integer num represented as a string, 
    // remove k digits from the number so that the new number is the smallest possible.

    // Input: num = "1432219", k = 3, Output: "1219"
    // Input: num = "10200", k = 1, Output: "200"
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        
        int i = 0;
        while(i < sb.length() - 1 && sb.charAt(i) == '0') i++;
        return sb.substring(i);
    }
}