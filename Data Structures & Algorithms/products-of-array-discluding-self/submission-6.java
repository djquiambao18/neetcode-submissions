class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force: O(n^2), unacceptable
        // do a first pass from left side
        int[] result = new int[nums.length];
        result[0] = 1;
        //     i = 0,1,2,3         i = 0,1,2,3
        // nums = [1,2,4,6]; result = [1,0,0,0];
        for(int i = 1; i < nums.length; i++) {
            // i = 1, i-1 = 0, result = [1, 1, 0, 0], nums = [1, 2, 4, 6]
            // result[1] = result[0] * nums[0];
            result[i] = result[i-1] * nums[i-1];
        }
        // then, keep a running variable to keep track of the product so far while moving from right-to-left:
        int currProduct = 1;
        for(int i = nums.length - 1; i > 0; i--) {
            //first, update the result at the current index (because we already skipped the current index previously, no need to worry)
            result[i] *= currProduct;
            currProduct *= nums[i];
        }
        // the last element at the left should be updated to the currProduct value
        // remember that this was originally set to 1
        result[0] = currProduct;

        return result;
    }
}  
