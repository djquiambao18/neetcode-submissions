class Solution {
    public int search(int[] nums, int target) {
        // check for only one element and if it matches target
        if(nums[0] == target) {
            return 0;
        }
        if(nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int right = nums.length - 1, left = 0, mid = left + (right - left) / 2;
        int answer = -1;
        while(right >= left) {
            if(nums[mid] == target) {
                answer = mid;
                break;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return answer;
    }
}
