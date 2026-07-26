class Solution {
    public int search(int[] nums, int target) {
        // O(log nums.length), find "target" and return its index.
        int index = -1;
        // check the left-most if it's greater or lesser than the right-most
        int left = 0, right = nums.length - 1, mid = left + (right - left) / 2;
        while(left <= right && nums[left] > nums[right]) {
            // rotated case:
            if(target > nums[right]) {
                // adjust right to be -1;
                right--;
            }
            else if(target < nums[left]) {
                left++;
            }
            mid = left + (right - left) / 2;
        }
        // normal binary search;
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
            // see if target is smaller or bigger than mid. then readjust the left or right position
            if(target < nums[mid]) {
                right = mid - 1;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return index;
    }
}
