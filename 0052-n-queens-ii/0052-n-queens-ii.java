class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return count;
    }

    void backtrack(int row, int n, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || d1.contains(row - col) || d2.contains(row + col)) continue;
            cols.add(col); d1.add(row - col); d2.add(row + col);
            backtrack(row + 1, n, cols, d1, d2);
            cols.remove(col); d1.remove(row - col); d2.remove(row + col);
        }
    }
}
