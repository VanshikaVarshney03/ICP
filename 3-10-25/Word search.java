class Solution {
    public boolean found(char[][] board, int i, int j, String word, int index) {
      
        if (index == word.length()) return true;

        int r = board.length;
        int c = board[0].length;

       
        if (i < 0 || j < 0 || i >= r || j >= c || board[i][j] == ' ' || board[i][j] != word.charAt(index)) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = ' '; 

        boolean f = found(board, i + 1, j, word, index + 1) ||
                    found(board, i - 1, j, word, index + 1) ||
                    found(board, i, j + 1, word, index + 1) ||
                    found(board, i, j - 1, word, index + 1);

        board[i][j] = ch; 
        return f;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (found(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }
}
