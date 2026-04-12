class Solution {
    public boolean isAnagram(String s, String t) {
        // if not the same length then they are not an anagram of each other
        if(s.length() != t.length())
            return false;
        // frequency count, lowercase english letters == 26 characters:
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0)
              return false;
        }
        return true;
    }
}
