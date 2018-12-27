public class RotateImage{
     public void rotate(int[][] m) {
        int n = m.length - 1;
        for(int i = 0; i <= n / 2; i++){
            for(int j = i; j < n - i; j++){
                // m[i][j]   m[j][n-i]
                // m[n-j][i] m[n-i][n-j]
                int t = m[i][j];
                // counter-clockwise
                // m[i][j] = m[j][n - i];
                // m[j][n - i] = m[n - i][n - j];
                // m[n - i][n - j] = m[n - j][i];
                // m[n - j][i] = t;

                // clockwise
                m[i][j] = m[n-j][i];
                m[n-j][i] = m[n-i][n-j];
                m[n-i][n-j] = m[j][n-i];
                m[j][n-i] = t;
            }
        }
    }
 
}