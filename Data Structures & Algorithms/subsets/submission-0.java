class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutionSet = new ArrayList<>();
        // [7] -> [] or [7]; [1,2,3] -> [] or [[1]] -> [] 
        // base-case?
        // choices 
        dfs(0, nums, new ArrayList<Integer>(), solutionSet);
        return solutionSet;
    }
    private void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> solutionSet) {
        if(index == nums.length) {
            // reached the end of the array so add the current copy of subset into the solutionSet
            solutionSet.add(new ArrayList<>(subset));
            return;
        }
        // decision / choice:
        // choice 1 (include nums[index]):
        subset.add(nums[index]);
        dfs(index + 1, nums, subset, solutionSet);
        // remove the number for backtracking:
        subset.remove(subset.size() - 1);

        // choice 2 (skip nums[index]):
        dfs(index + 1, nums, subset, solutionSet);
    }
}
