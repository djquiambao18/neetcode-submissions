class Solution {
    public int lengthOfLongestSubstring(String s) {
        // shortcut, if length of 1, or 0, just return the length of the string:
        short minimumLength = 1;
        if(s.length() <= minimumLength) {
            return s.length();
        }
        // we can probably approach this with using a set to keep track of the longest substring encountered
        // by keeping track of the characters
        // 1. zxyzxyz -> 3
        // zxy, xyz, yzx, zxy, xyz -> 3 at most
        // 2. xxxx -> 1
        // x, x, x, x 
        // HOWEVER, this fails for case like s="dvdf",
        // if we don't use pointers to keep track of the
        // end and beginning of the window since that would return as 2 (df) instead of 3 (vdf)
        // instead, we need a "head" and "tail" s.t. when we encounter a duplicate character at the "head"
        // then we shrink the "tail" by one.
        // we always check the maxlength and update per iteration
        Set<Character> dupeRec = new HashSet<>();
        int tail = 0, head = 0;
        // we can still use the SET
        int maxLength = head - tail;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            while(dupeRec.contains(chars[i])) {
                dupeRec.remove(chars[tail]);
                tail++;
            }
            dupeRec.add(chars[i]);
            head++;
            maxLength = Math.max(maxLength, head - tail);
        }
        return maxLength;
    }
}
