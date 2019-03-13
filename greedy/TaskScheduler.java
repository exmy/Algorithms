class TaskScheduler{

    // leetcode 621

    // Input: tasks = ["A","A","A","B","B","B"], n = 2
    // Output: 8
    // Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

    // AXXAXX A
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char ch: tasks) c[ch - 'A']++;
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}