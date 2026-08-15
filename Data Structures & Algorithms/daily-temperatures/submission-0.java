class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack - monotonically increasing
        int n = temperatures.length;
        // defaults to all 0's
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            // 
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
