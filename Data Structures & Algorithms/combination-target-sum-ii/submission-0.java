class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // int[] sortedCandidates = Arrays.sort(candidates);
        Arrays.sort(candidates);
        result = new ArrayList<>();
        // constraints:
        // 1. each element from candidates may only be chosen ONCE within a combo
        // 2. solution set mus not contain duplicate combos
        // 3. candidates may contain duplicates

        // ex. [9, 2, 2, 4, 6, 1, 5], target = 8
        // [[1,2,5], [2,2,4], [2,6]]
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return result;

    }
    private void dfs(int[] candidates, int index, int target, List<Integer> subset) {
        if(target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if(index >= candidates.length || target < 0) {
            return;
        }
        subset.add(candidates[index]);
        dfs(candidates, index + 1, target - candidates[index], subset);
        subset.remove(subset.size() - 1);

        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(candidates, index + 1, target, subset);
    }
}
