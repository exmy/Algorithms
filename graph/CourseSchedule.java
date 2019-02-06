class CourseSchedule{

    // 判断有向图是否有环
    // 1. dfs
    List<Integer>[] graph;
    boolean[] vis;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        vis = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }
        return true;
    }
    
    private boolean dfs(int u){
        // cycle
        if(vis[u]) return false;
        
        vis[u] = true;
        for(int i = 0; i < graph[u].size(); i++){
            int v = graph[u].get(i);
            if(!dfs(v)) return false;
        }
        vis[u] = false;
        return true;
    }

    // 2. bfs topsort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                ans++;
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : graph[u]){
                if(--indegree[v] == 0) {
                    ans++;
                    queue.offer(v);
                }
            }
        }
        
        return ans == numCourses;
    }
}