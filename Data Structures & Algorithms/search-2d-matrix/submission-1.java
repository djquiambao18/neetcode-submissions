class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int top = 0, bottom = ROWS - 1;

        // search each row first to see which row the target could be in, then we target that row in the next binary search
        // we then just perform a regular binary search in that row
        // this gives us an O(log ROWS + log COLS) == O(log(rows * cols));

        while(top <= bottom) {
            int row = (top + bottom) / 2;
            // if the target is greater than the last element of the current row, move down
            if(target > matrix[row][COLS-1]) {
                top = row + 1;
            }
            // if the target is smaller than the first element of the row, then move up:
            else if(target < matrix[row][0]) {
                bottom = row - 1;
            }
            // otherwise, the target is in this row, so break
            else {
                break;
            }
        }
        // also check for the case when top > bottom, then target is not in the matrix
        if(top > bottom) {
            return false;
        }
        int row = (top + bottom) / 2;
        int left = 0, right = COLS - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target > matrix[row][mid]) {
                left = mid + 1;
            }
            else if(target < matrix[row][mid]) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        // if we reached here, then target isnt anywhere
        return false;
    }
}
