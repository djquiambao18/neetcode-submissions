class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // return result array where result at 'i' = # of days after temp[i] BEFORE a warmer temp ON A FUTURE day (looking ahead)
        // ex. temperatures = [27, 20, 30, 25, 36];
        // days [i] before a warmer temp appears in the future
        // if none, put 0
        // result = [2, 1, 2, 1, 0];
        // day 1 to day 5
        // we keep the stack sorted so temperatures decrease from bottom to top
        // this way, when a bigger temp comes in, we know it's the next warmer day for everyone we pop
        // and store the difference from the current index to the previous (lower temp) index in the result array.

        // initializes to 0
        int[] result = new int[temperatures.length];
        // to keep track of the previous days we save the indexes of the previous days in a stack
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            // check the stack if its not empty and the current temperature is greater than the previous one (top of stack)
            // if it is, then we can be sure that the temp for the current day is greater than everything else in the stack so process
            // them all and update the results array accordingly using the stored indexes in the stack:

            // remember: contents of stack are indices of temperatures (represents "Days").
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // update the results array with the days since the lower temp (top of stack) than today
                int index = stack.pop();
                result[index] = i - index; // difference between the days
            }
            // add the current day to the top of stack.
            stack.push(i);
        }
        return result;
    }
}
