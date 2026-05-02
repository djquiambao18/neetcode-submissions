class Solution {
    public boolean isValid(String s) {
        // O(1) space for checking
        Set<Character> validChars = new HashSet<>(Arrays.asList('[',']','{','}','(',')'));
        // O(s.length) space for stack:
        Stack<Character> parentheses = new Stack<>();
        // contents of stack may be null so make sure to check for it before pop
        // set as true by default since we want to push things into the stack first
        boolean valid = true;
        // we can check here first if the first character is a CLOSING parenthesis which means INVALID:
        if(s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')')
            return false;
        // place parentheses in stack:
        for(Character c : s.toCharArray()) {
            // make sure that the character is a valid parenthesis per requirement
            if (validChars.contains(c)) {
                // switch-case to check if it's a closing parenthesis:
                switch(c) {
                    case ')':
                        valid = !parentheses.empty() && ('(' == parentheses.pop());
                        break;
                    case '}':
                        valid = !parentheses.empty() && ('{' == parentheses.pop());
                        break;
                    case ']':
                        valid = !parentheses.empty() && ('[' == parentheses.pop());
                        break;
                    default:
                        parentheses.push(c);
                }
            }
            // check if valid is still true, otherwise return false:
            if (!valid) {
                // return valid here means valid is FALSE
                return valid;
            }
        }
        // return valid here means valid is TRUE
        return parentheses.empty() && valid;
    }
}
