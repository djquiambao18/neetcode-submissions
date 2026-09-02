class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, target, result, new ArrayList<Integer>());
        return result;
    }

    // need to pass nums input, index, target or remaining, result set, subset (List<Integer>) 
    private void dfs(int[] nums, int index, int target, List<List<Integer>> result, List<Integer> subset) {
        // cases:
        // first base case, 
        // Add: if result - target == 0 ? add to result set
        // Dont add: case when result - target < 0 OR index is > nums.length? return dont add (no need to check if result - target != 0 since that would be covered by first case)
        
        // means we've reached a solution so add it to result
        if(target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // otherwise, the case when target is negative (we've removed too much or there's no valid amount to reach target - reached end of array nums)
        // so just return
        if(target < 0 || index >= nums.length) {
            return;
        }
        
        // make choice 1: include the current number and reduce the target by amount of current element
        subset.add(nums[index]);
        dfs(nums, index, target - nums[index], result, subset);
        // backtrack
        subset.remove(subset.size() - 1);

        // skip step
        dfs(nums, index + 1, target, result, subset);
    }
}
