class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++)
            if (!isValidRow(board, i)) return false;
        
        for (int j = 0; j < 9; j++)
            if (!isValidCol(board, j)) return false;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!isValidSubBox(board, i * 3, j * 3)) return false;

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') continue;
            int index = board[row][col] - '1';
            if (seen[index]) return false;
            seen[index] = true;
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for(int row = 0; row < 9; row++) {
            if (board[row][col] == '.') continue;
            int index = board[row][col] - '1';
            if (seen[index]) return false;
            seen[index] = true;
        }

        return true;
    }

    private boolean isValidSubBox(char[][] board, int row, int col) {
        boolean[] seen = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == '.') continue;
                int index = board[i][j] - '1';
                if (seen[index]) return false;
                seen[index] = true;
            }
        }

        return true;
    }
}
