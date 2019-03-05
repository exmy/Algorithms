class CourseScheduleII{

    // leetcode 210
    // topsort

    public int[] findOrder(int n, int[][] p) {
        List<Integer>[] g = new ArrayList[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for(int i = 0; i < p.length; i++){
            int v = p[i][0], u = p[i][1];
            g[u].add(v);
            indegree[v]++;
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                cnt++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
            for(int v: g[u]){
                if(--indegree[v] == 0){
                    queue.offer(v);
                    cnt++;
                }
            }
        }
        if(cnt != n) return new int[0];
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
}