import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    void backtrack(char[][] board, int row, int n, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || d1.contains(row - col) || d2.contains(row + col)) continue;
            board[row][col] = 'Q';
            cols.add(col); d1.add(row - col); d2.add(row + col);
            backtrack(board, row + 1, n, cols, d1, d2);
            board[row][col] = '.';
            cols.remove(col); d1.remove(row - col); d2.remove(row + col);
        }
    }
}
