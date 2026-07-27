class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* instead of going through the nums in place, we can trade-off time for some space
           to store the encountered result and their index in a map.
           For example: nums = [3,4,5,6], target = 7
           since we already know the values in the array, all we need to do is find the other pair
           in the array as we go through it for the given target.
           nums[0] - target = nums[1] is mathematically equivalent, s.t. 3 - 7 = -4 -> Math.abs(-4) = 4
           store the result into a map, (4) -> [0], then the next iteration we encounter 4 and we get its index
           since 4 is in the map, we return the index we saw this and the current index
        */
        // no need to check the bounds, since there will always be a valid answer and no null condition
        // initialize the map:
        Map<Integer, Integer> encounteredNums = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            // check for mapentry
            // [()]
            // 1. 3 ? false
            // 2. 4 ? true
            if(encounteredNums.containsKey(nums[i])) {
                // 2. 1, 0
                result[0] = encounteredNums.get(nums[i]);
                result[1] = i;
                break;
            }
            // perform the calculations
            // 1. 7-3 = 4
            // 2. 7-4 = 3
            int sum = target - nums[i];
            // 1. (4, 0)
            // 2. (3, 1)
            encounteredNums.put(sum, i);
        }
        return result;
    }
}
