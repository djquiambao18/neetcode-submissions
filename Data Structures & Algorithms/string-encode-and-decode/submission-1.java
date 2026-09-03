class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) {
            return new String(); // empty string
        }
        // store the sizes of each string in a list:
        List<Integer> strsSize = new ArrayList<>();
        for(String s : strs) {
            // add the length of each string to the string size arraylist
            strsSize.add(s.length());
        }
        // then write every string with their length into a single string, 
        // size section will be separated by comma and marked with a single special character
        // the length or size of the string recorded will tell us exactly when each string begins and ends (by its length) during decoding
        StringBuilder strBuilder = new StringBuilder();
        for(Integer i : strsSize) {
            // get the number in separated by a comma, but remove the last comma
            strBuilder.append(i).append(",");
        }
        strBuilder.append("#");
        //then, append the strings (will appear in the order we recorded each of their lengths)
        for(String s : strs) {
            strBuilder.append(s);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        // first, check if the encoded string "str" is empty, if so, return an empy list:
        if(str.length() == 0) {
            return new ArrayList<String>();
        }
        // to decode, we first need to get the sizes then check each character of the string until that size
        List<Integer> stringSize = new ArrayList<>();
        int index = 0;
        StringBuilder num = new StringBuilder();
        for(index = 0; str.charAt(index) != '#'; index++) {
            char c = str.charAt(index);
            if(c == ',') {
                stringSize.add(Integer.parseInt(num.toString()));
                num = new StringBuilder();
            } else {
                num.append(c);
            }
        }
        index++;
        // start should now correctly point to where '#' char is
        // contain the decoded strings
        List<String> strs = new ArrayList<>();
        
        for(int i : stringSize) {
            strs.add(str.substring(index, index + i));
            index += i;
        }
        return strs;
    }
}
