class Solution {
    public boolean exist(char[][] board, String word) {
        // check the first letter of word and navigate the board to check for the letter
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                // moment backtracking returns true, means we've searched all possible spaces to get the word
                if(backtrack(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    // backtracking
    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        // base cases:
        // if index == board.length, return true;
        if(index == word.length()) {
            return true; // reached the end of the grid
        }
        // check the out of bounds or if the current character doesnt match the word's character, or it's used (cannot use more than once)
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || board[row][col] == '#') {
            return false;
        }
        // mark current position as visited/used otherwise
        board[row][col] = '#';

        // try the next position for the next word's character:
        boolean result = backtrack(board, row - 1, col, word, index + 1) ||
                         backtrack(board, row + 1, col, word, index + 1) ||
                         backtrack(board, row, col - 1, word, index + 1) ||
                         backtrack(board, row, col + 1, word, index + 1);
        // restore the cell to original character
        board[row][col] = word.charAt(index);
        return result;
    }
}
