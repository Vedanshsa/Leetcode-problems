import java.util.*;

class Solution {
    public long maxSum(int[] a, int k, int m) {
        Arrays.sort(a);
        long s = 0;
        for (int i = a.length - 1; i >= a.length - k; i--) {
            if (m > 1) {
                s += (long) a[i] * m;
                m--;
            } else s += a[i];
        }
        return s;
    }
}
