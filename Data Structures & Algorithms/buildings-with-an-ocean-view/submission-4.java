class Solution {
    public int[] findBuildings(int[] heights) {
        // alternate solution does not need O(n) extra space (no stack needed)
        int[] result = new int[heights.length];
        // we will still check from the right to left and get the
        // max height from the right side
        int maxHeight = 0;
        // keep track of the right side
        // start from +1 past the length
        int rightIndex = heights.length;
        for(int i = heights.length - 1; i >= 0; i--) {
            // check if the current height is greater than the max height so far (rightIndex)
            // the equal check is skipped looking from the right
            if(heights[i] > maxHeight) {
                // if so, add the entry by adjusting the rightIndex first (keeping the last record intact)
                // can use pre-decrement
                result[--rightIndex] = i;
                maxHeight = heights[i];
            }
        }
        return Arrays.copyOfRange(result, rightIndex, heights.length);
    }
}