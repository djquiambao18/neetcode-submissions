class Solution {
    public int maxArea(int[] heights) {
        // edge case, return either of the lowest walls
        if (heights.length == 2) {
            return Math.min(heights[0], heights[1]);
        }
        // need to keep track of the current max and the global max
        // to calculate the current max, consider the lower wall of the two sides
        // then find the difference between the two walls to find its distance
        // then, just perform basic geometry l * w (or height * width)
        // we also need two ptrs, one on the left side, the other on the right.
        // we increment or decrement accordingly depending on which side has the higher wall
        // if the left side's wall is higher, then we explore the right side more by decrementing the right wall pointer
        // if the right side's wall is higher, then explore the left side by incrementing the left wall ptr
        int globalMax = Integer.MIN_VALUE, currMax = Integer.MIN_VALUE, left = 0, right = heights.length - 1;
        while (left < right) {
            currMax = Math.min(heights[left], heights[right]) * (right - left);
            globalMax = Math.max(globalMax, currMax);
            if(heights[left] > heights[right]) {
                right--;
            }
            else {
                left++;
            }
        }
        return globalMax;
    }
}
