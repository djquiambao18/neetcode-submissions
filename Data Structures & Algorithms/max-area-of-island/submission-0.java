class Solution {
    // approach: num of islands but count max 1's
    // dfs or bfs
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                int val = grid[row][col];
                if(val == 1) {
                    int temp = dfs(grid, row, col);
                    max = Math.max(temp, max);
                }
            }
        }
        // this would be 0 if no island ever existed
        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        if(grid[row][col] == 1) {
            grid[row][col] = 0; // mark as visited
            int res = 1;
            for(int[] direction : directions) {
                res += dfs(grid, row + direction[0], col + direction[1]);
            }
            return res;
        }
        return 0;
    }
}
