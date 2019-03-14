class GroupAnagrams{

    // leetcode 49
    // Given an array of strings, group anagrams together.

    // Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    /* Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for(String s: strs){
            int hash = 1;
            for(char ch: s.toCharArray()) hash *= p[ch-'a'];
            map.computeIfAbsent(hash, x -> new ArrayList<>()).add(s);
        }
        for(int key: map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}