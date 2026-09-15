class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // rotate image clockwise by 90deg
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                // i_0[j0,j1,j2] => j_0[i_2, i_1, i_0]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // flip the image to the left/right, stop at mid
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n/2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}