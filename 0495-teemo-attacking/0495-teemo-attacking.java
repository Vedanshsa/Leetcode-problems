class Solution {
    public int findPoisonedDuration(int[] t, int d){
    int ans = 0;
        for (int i = 0; i < t.length - 1; i++) {
            ans += Math.min(d, t[i+1] - t[i]);
        }
        return ans + d;
    }
}