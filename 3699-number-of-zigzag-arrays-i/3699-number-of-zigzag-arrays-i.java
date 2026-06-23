class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int size = r - l + 1;
        long[][] dp = new long[size][2];
        long[][] prefix = new long[size + 1][2];

        for (int v = 0; v < size; v++) {
            dp[v][0] = v;
            dp[v][1] = size - 1 - v;
        }

        for (int i = 2; i < n; i++) {
            for (int v = 0; v < size; v++) {
                prefix[v + 1][0] = (prefix[v][0] + dp[v][0]) % MOD;
                prefix[v + 1][1] = (prefix[v][1] + dp[v][1]) % MOD;
            }

            long[][] ndp = new long[size][2];

            for (int v = 0; v < size; v++) {
                ndp[v][0] = prefix[v][1];
                ndp[v][1] = (prefix[size][0] - prefix[v + 1][0] + MOD) % MOD;
            }

            dp = ndp;
        }

        long ans = 0;
        for (int v = 0; v < size; v++) {
            ans = (ans + dp[v][0] + dp[v][1]) % MOD;
        }

        return (int) ans;
    }
}