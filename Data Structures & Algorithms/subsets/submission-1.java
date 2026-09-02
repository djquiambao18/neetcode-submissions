class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // base-case
        if(index >= nums.length) {
            // add the current copy of subset into result set:
            result.add(new ArrayList<>(subset));
            return;
        }
        // make choices
        // choice 1, include the current element at index
        subset.add(nums[index]);
        // recurse to next
        dfs(nums, index + 1, subset, result);
        // backtracking step (remove the last entry)
        subset.remove(subset.size() - 1);

        // choice 2: don't include/skip
        dfs(nums, index + 1, subset, result);
    }
}
