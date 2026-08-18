class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int currMax = nums[0], globalMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currMax += nums[i];
            if(currMax <= nums[i]) {
                currMax = nums[i];
            }
            globalMax = Math.max(currMax, globalMax);
        }
        return globalMax;
    }
}
