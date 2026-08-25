class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // sr = starting row, sc = starting column, color = color to change the pixel TO
        // ex. image[sr][sc] = begin from this pixel, take note of its current color, then flip it to "color"
        // immediately
        int startingColor = image[sr][sc];
        // first, check if the "startingColor" is already the same as "color"
        // return as-is if so
        if(startingColor == color) {
            return image;
        }
        // directions to traverse from each pixel
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // use BFS to traverse the adjacent pixels and flip them to "color".
        // check the bounds in each exploration to skip that traversal
        // bounds: row < 0 OR row >= image.length OR col < 0 OR col >= image[row].length
        // we need to remember the positions, not the actual pixel itself so thats whats needed in the Queue
        Queue<int[]> toVisit = new ArrayDeque<>();
        // this way we can get the "row" -> [0], and "col" -> [1] for retrieval
        toVisit.offer(new int[]{sr, sc});
        // repaint to "color", same as marking as "visited".
        image[sr][sc] = color;
        // bfs
        while(!toVisit.isEmpty()) {
            int[] current = toVisit.poll();
            int row = current[0];
            int col = current[1];
            for(int[] direction : directions) {
                // skip the iteration if it's out of bounds
                int nRow = row + direction[0];
                int nCol = col + direction[1];
                if(nRow < 0 || nRow >= image.length || nCol < 0 || nCol >= image[nRow].length) {
                    continue;
                }
                // enqueue if it's the same pixel/color as starting
                if(image[nRow][nCol] == startingColor) {
                    toVisit.offer(new int[]{nRow, nCol});
                    // recolor to mark as visited:
                    image[nRow][nCol] = color;
                }
            }
        }
        return image;
    }
}