class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        if(temp == 0)
            return true;
        if(temp < 0)
            return false;
        int reverse = 0;
        // reverse the integer with modulo
        // 123 % 10 => 3
        // reverse = (reverse * 10) + 3
        // reverse = (0) + 3
        // 123 / 10 => 12
        // 2. 12%10 => 2
        // reverse = (3 * 10) + 2 -> reverse = (30) + 2 -> 32
        // 12/10 => 1
        // 3. 1%10 => 1
        // reverse = 32*10 + 1 -> 321
        while(temp != 0) {
            // extract the last digit:
            int last = temp % 10;
            // ex1. reverse = (0 * 10) + 3
            reverse = (reverse * 10) + last;
            // 'remove' the last digit
            temp /= 10;
        }
        return x == reverse;
    }
}