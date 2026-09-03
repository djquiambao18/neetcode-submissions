// Daily Temps
// temperatures where temperatures[i] == daily temps on the ith day
// return an array result where result[i] is the number of days before a warmer temp appears ona. future day. If no day in the future where warmer temp will appear for the ith day, set result[i] to 0 instead.

// ex:
// temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
// output = [1, 1, 4, 2, 1, 1, 0, 0]

// we can use a stack to keep track of the warmer temperatures. if we see a warmer temperature than the current top of the stack, then pop it and find the difference in its position, store it in result using the stack's tracked index

// import java.util.Deque;
// import java.util.ArrayDeque;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[temperatures.length];

    for(int i = 0; i < temperatures.length; i++) {
      // monotonic step
      while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        // store the day difference
        result[index] = i - index;
      }
      stack.push(i);
    }
    return result;
  }
}