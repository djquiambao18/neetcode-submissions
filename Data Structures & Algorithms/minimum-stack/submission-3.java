// import java.util.Stack;
class MinStack {
    // where we push all the values
    private Stack<Integer> mainStack;
    // stack where we store the minimum vals such that the most minimum is always at the top

    private Stack<Integer> minStack;
    public MinStack() {
        this.mainStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    // push the value to minstack if it's smaller than the current top at minStack
    // then push to mainstack
    public void push(int val) {
        if(minStack.empty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        mainStack.push(val);
    }
    // removal to should always check the minStack first and see if it matches the mainstack.
    // if so, remove both the top from the minstack and mainstack, otherwise just the mainstack
    // then, we need to reconcile the mainstack and minstack again, so see if the current top of minstack
    // is greater than or equal to the current top of mainstack
    // if so, push the value to minStack, otherwise, just ignore
    public void pop() {
        int mainVal = mainStack.pop();
        // also remove the entry from minstack if it's the same value
        if(mainVal == minStack.peek()) {
            minStack.pop();
        }
        // if((minStack.empty() && !mainStack.empty())) {
        //     minStack.push(mainStack.peek());
        // }
    }
    
    // get the mainStack's top
    public int top() {
        return mainStack.peek();
    }
    
    // get the minStack's top
    public int getMin() {
        return minStack.peek();
    }
}
