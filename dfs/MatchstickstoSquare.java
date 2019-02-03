class MatchstickstoSquare{

    List<Integer> numsList;
    int[] sums = new int[4];
    int side;
    
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int p = 0;
        for(int n: nums) p += n;
        side = p / 4;
        if(side * 4 != p) return false;
        
        numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList, Collections.reverseOrder());
        
        return dfs(0);
    }
    
    private boolean dfs(int index){
        if(index == numsList.size()){
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }
        int ele = numsList.get(index);
        for(int i = 0; i < 4; i++){
            if(sums[i] + ele <= side){
                sums[i] += ele;
                if(dfs(index + 1)) return true;
                sums[i] -= ele;
            }
        }
        return false;
    }
    
}