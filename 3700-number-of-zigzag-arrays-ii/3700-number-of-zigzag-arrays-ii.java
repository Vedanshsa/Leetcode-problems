import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;
        long[][] M = new long[size][size];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                if (y == x) continue;
                if (y < x) M[x][m + y] = 1;
            }
            for (int y = 0; y < m; y++) {
                if (y == x) continue;
                if (y > x) M[m + x][y] = 1;
            }
        }

        long[] init = new long[size];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a == b) continue;
                if (a < b) init[b]++;
                else init[m + b]++;
            }
        }

        long[][] power = matrixPow(M, n - 2);
        long[] result = multiply(init, power);
        long ans = 0;
        for (long v : result) ans = (ans + v) % MOD;
        return (int) ans;
    }

    private long[] multiply(long[] vec, long[][] M) {
        int n = vec.length;
        long[] res = new long[n];
        for (int j = 0; j < n; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (vec[i] != 0) sum = (sum + vec[i] * M[i][j]) % MOD;
            }
            res[j] = sum;
        }
        return res;
    }

    private long[][] matrixMul(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] matrixPow(long[][] M, int exp) {
        int n = M.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = matrixMul(res, M);
            M = matrixMul(M, M);
            exp >>= 1;
        }
        return res;
    }
}
