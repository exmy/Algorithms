/*
  The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
  Given two integers x and y, calculate the Hamming distance.
*/

public class HammingDistance{
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int ans = 0;
        while(r > 0){
            ans++;
            r &= (r - 1);
        }
        return ans;
    }
}