class Solution {
    public boolean isPalindrome(String s) {
        // two-pointer soln, O(1) space complexity, O(n) runtime complexity
        if (s.length() == 1) 
            return true;
        int left = 0, right = s.length() - 1;
        while(left < right) {
            // only check alphanumeric characters - left side
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // only check alphanumeric characters - right side
            while(right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare the left and right side if they are the same character:
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            // update pointers
            left++;
            right--;
        }
        return true;
    }
}
