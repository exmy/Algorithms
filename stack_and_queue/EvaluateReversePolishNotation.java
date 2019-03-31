class EvaluateReversePolishNotation{

    // leetcode 150
    // Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    // Input: ["2", "1", "+", "3", "*"]
    // Output: 9
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);
        
        for(String token: tokens){
            if(op(token)){
                int b = s.pop();
                int a = s.pop();
                s.push(map.get(token).apply(a, b));
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
    
    private boolean op(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}