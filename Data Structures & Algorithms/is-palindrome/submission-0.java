class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        String cleaned = lower.replaceAll("[^a-zA-Z0-9]", "");
        Stack<Character> palStack = new Stack<>();
        
        for (int i = 0; i < cleaned.length(); i++) {
            palStack.push(cleaned.charAt(i));
        }
        // pop the stack while comparing each character in the string
        // the stack pop will give us a reverse order.
        for(int i = 0; i < cleaned.length(); i++) {
            if(cleaned.charAt(i) != palStack.pop())
                return false;
        }
        return true;
    }
}
