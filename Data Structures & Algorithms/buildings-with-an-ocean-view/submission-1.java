class Solution {
    public int[] findBuildings(int[] heights) {
        // if(heights.length == 1) {
        //     return new int[]{heights.length - 1};
        // }
        // monotonic stack?
        // every building to the RIGHT of the current building "heights[i]" height
        // 1 - 2 - 1 - 1 - 3 - 4 - 2 (heights.length == 0)
        // stack will keep track of current building's height and compare to the current temperature 
        // before each push to stack, we first check if the current height of the building is
        // can we traverse from right to left?
        List<Integer> result = new ArrayList<>();
        // condition: if the current height is shorter than the top of the stack, skip adding it?
        Deque<Integer> stack = new ArrayDeque<>();
        // add the end of the ocean view (last element will always have ocean view);
        stack.push(heights.length - 1);
        for(int height = heights.length - 2; height >= 0; height--) {
            // look from current height to left and compare if current is shorter than top
            if(heights[height] <= heights[stack.peek()]) {
                continue;
            }
            stack.push(height);
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}