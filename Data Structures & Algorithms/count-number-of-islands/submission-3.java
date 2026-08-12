class Solution {
    public int numIslands(char[][] grid) {
        // Solve with BFS (using queue / linkedlist)
        // move to the right (row, col + 1)
        // move to left = (row, col - 1)
        // move up = (row - 1, col)
        // move down = (row + 1, col)

        // number of islands counter
        int numIsland = 0;
        
        // dimension of grid:
        int ROWS = grid.length, COLS = grid[0].length;

        // Check the grid for each possible '1' value which indicates an island
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                // check for an island existence:
                if(grid[row][col] == '1') {
                    // found an island, perform BFS to search every neighbor in all 4 directions:
                    bfs(grid, row, col);
                    // Increment the island counter (only incremented when all possible directions have been exhausted)
                    numIsland++;
                }
            }
        }

        // return the result:
        return numIsland;
    }

    private void bfs(char[][] grid, int row, int col) {
        // iterative, initialize a queue for BFS traversal:
        Queue<int[]> neighbors = new LinkedList<int[]>();
        neighbors.offer(new int[]{row, col});
        // mark current cell as visited ('0'):
        grid[row][col] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(neighbors.size() != 0) {
            int[] island = neighbors.poll();
            row = island[0];
            col = island[1];
            // explore all neighbors of grid[row][col]
            for(int [] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];
                // add cell as island to the queue:
                if(newRow < grid.length && newCol < grid[0].length && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] == '1' ) {
                    neighbors.offer(new int[]{newRow,newCol});
                    grid[newRow][newCol] = '0'; // visited
                }
            }
        }
    }
}
