public class ReconstructQueue{

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