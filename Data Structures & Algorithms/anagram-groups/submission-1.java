class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map of a list of same strings, key is the frequency of chars (2a3b1c)
        Map<String, List<String>> anagrams = new HashMap<>();
        // first, go through each string, count the character frequency:
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // use the property of arrays such that the index of the character in the array refers to its
            // charset value if offset/diff'ed by a reference character.
            int[] charFreq = new int[26];
            for(int j = 0; j < str.length(); j++){
                // increment to count the frequency of character in the string.
                charFreq[str.charAt(j) - 'a'] += 1;
            }
            String temp = Arrays.toString(charFreq);
            List<String> group = anagrams.getOrDefault(temp, new ArrayList<String>());
            group.add(str);
            anagrams.put(temp, group);
        }
        List<List<String>> result = new ArrayList<>();
        // list out all the entries in the map:
        for(Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            List<String> ent = new ArrayList<String>();
            for(String val : entry.getValue()) {
                ent.add(val);
            }
            result.add(ent);
        }
        return result;
    }
}
