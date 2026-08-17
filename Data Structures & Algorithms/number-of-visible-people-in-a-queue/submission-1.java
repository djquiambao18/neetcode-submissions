class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[heights.length];
        for(int i = heights.length - 1; i >= 0; i--) {
            int count = 0;
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                count++;
            }
            answer[i] = count;
            if(!stack.isEmpty()) {
                answer[i] = answer[i] + 1;
            }
            stack.push(i);
        }
        return answer;
    }
}