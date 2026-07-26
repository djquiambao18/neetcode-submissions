class Solution {
    public int search(int[] nums, int target) {
        // O(log nums.length), find "target" and return its index.
        int index = -1;
        // check the left-most if it's greater or lesser than the right-most
        int left = 0, right = nums.length - 1, mid = left + (right - left) / 2;
        // binary search;
        while(left <= right) {
            // first check if the target is in one of the positions
            if(nums[left] == target){
                index = left;
                break;
            }
            if(nums[right] == target) {
                index = right;
                break;
            }
            if(nums[mid] == target){
                index = mid;
                break;
            }
            mid = left + (right - left) / 2;
            // see if target is on the left or right side sorted
            if(nums[left] <= nums[mid]) {
                // check left-side first, and see if target is there
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }
                // when nums[left] > target OR nums[mid] < target
                else {
                    left = mid + 1;
                }
            }
            else {
                if(nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}
