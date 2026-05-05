class Solution {
    public int findMin(int[] nums) {
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        // // check if the left-most side of the array is less than the right-most side that means
        // // no rotation or rotated the length of array
        // if (nums[0] < nums[nums.length - 1]) {
        //     return nums[0];
        // }

        // otherwise, do a binary search and check the right-side for rotation:
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // find the middle:
            int mid = left + (right - left) / 2;
            // case when the right side is smaller than the middle:
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // otherwise, adjust the left-side. this will be the closure:
            else {
                right = mid;
            }
        }
        return nums[right];
    }
}
