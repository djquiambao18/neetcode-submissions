class Solution {
    public int findMin(int[] nums) {
        // O(log n) time:
        // using binary search, we can check whether the left is greater than the right side, if so it's rotated.
        int minimum = 1000; // upper-constraint value is 1000, no number greater even if only one element

        int left = 0, right = nums.length - 1, mid = left + (right - left) / 2;
        // start search
        while(left <= right) {
            minimum = Math.min(minimum, nums[mid]);
            // assume rotation:
            // check if the number at the right side is smaller than the middle, so it's rotated.
            // if so, adjust the left side to be mid + 1, as the minimum is on the right-side
            if(nums[right] < nums[mid]) {
                left = mid + 1;
            }
            // otherwise, it would be on the left-side.
            else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
            minimum = Math.min(nums[mid], minimum);
        }
        return minimum;
    }
}
