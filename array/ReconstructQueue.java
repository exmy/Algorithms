public class ReconstructQueue{

    // problem
    // Suppose you have a random list of people standing in a queue. 
    // Each person is described by a pair of integers (h, k), 
    // where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
    // Write an algorithm to reconstruct the queue.


    // input:  [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    // output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

    // 思路
    // 首先按照h降序、k升序排序

    public int[][] reconstructQueue(int[][] p) {
        if(p == null || p.length == 0 || p[0].length == 0) return new int[0][0];
        Arrays.sort(p, (a, b) -> {
            if(b[0] == a[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
      
        List<int[]> tmp = new LinkedList<>();
        for(int i = 0; i < p.length; i++){
            tmp.add(p[i][1], new int[]{p[i][0], p[i][1]});
        }
        int i = 0;
        for(int[] t: tmp){
            p[i++] = t;
        }
        return p;
    }

    // more clean
    public int[][] reconstructQueue(int[][] p) {
        if(p == null || p.length == 0 || p[0].length == 0) return new int[0][0];
        Arrays.sort(p, (a, b) -> {
            if(b[0] == a[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
      
        List<int[]> tmp = new LinkedList<>();
        for(int[] t: p) tmp.add(t[1], t);
        return tmp.toArray(new int[p.length][]);
    }
}