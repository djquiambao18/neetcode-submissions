class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // use stack to keep track of the previous elements and compare them to the current element
        // if the current element is greater than the top of the stock, then its very likely it's also greater than the
        // current contents of the stack, so empty it and write the next greater element for their positions:

        // nums1 is subset of nums2, nums2 has unique elems:
        // for each i in nums1, find index 'j' such that nums1[i] == nums2[j] , then find the next greater element of nums2[j] in nums2.
        // store contents of nums1 in map, lookup for nums2:
        // tradeoff space for time (O(nums2.length))
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        // result size is bound to the length of nums1
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        // use stack for tracking the lesser numbers, then pop them when we find the 
        // then lookup nums1 in nums2 at constant time
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < nums2.length; i++) {
            // int index = map.get(nums2[i]);
            // check the stack
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int num = stack.pop();
                if(map.containsKey(num)) {
                    int index = map.get(num);
                    result[index] = nums2[i];
                }
            }
            stack.push(nums2[i]);
        }
        return result;
    }
}