class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; j >= 0;)
            a[k--] = i >= 0 && a[i] > b[j] ? a[i--] : b[j--];
    }
}
