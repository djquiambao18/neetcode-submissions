class Solution {
    public int numIslands(char[][] grid) {
        // Directions: 
        // Right -> Left = [y][x-1]
        // Left -> Right = [y][x+1]
        // Up -> Down = [y+1][x]
        // Down -> Up = [y-1][x]
        // go through the grid, checking for "1"s, when we find one, then perform dfs to it and its neighbors.
        // boundary checks, skip water (if y < 0 || y >= grid.length || x < 0 || x >= grid[0].length || grid[x][y] == '0')
        // each '1' is an island, then check adjacent sides (vertical or horizontal) in a DFS manner
        // for each 'visited', we mark it '0'.
        // then increment the count of islands at the end of exploration of its neighbors
        int result = 0;
        // kickoff dfs:
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[0].length; x++) {
                if(grid[y][x] == '1') {
                    dfs(grid, y, x);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int y, int x) {
        // char[y][x]
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        dfs(grid, y+1, x);
        dfs(grid, y-1, x);
        dfs(grid, y, x+1);
        dfs(grid, y, x-1);
    }
}
