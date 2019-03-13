class Searcha2DMatrixII{

    // leetcode 240
    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    // Integers in each row are sorted in ascending from left to right.
    // Integers in each column are sorted in ascending from top to bottom.

    public boolean searchMatrix(int[][] a, int target) {
        if(a == null || a.length == 0) return false;
        int n = a.length, m = a[0].length;
        int i = 0, j = m - 1;
        while(i < n && j >= 0){
            if(a[i][j] == target) return true;
            if(a[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}