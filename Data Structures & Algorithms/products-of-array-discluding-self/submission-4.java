class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Sol'n 2: 
        int size = nums.length;
        int[] result = new int[size];
        // initialize the first input as 1
        result[0] = 1;
        // build from the left-to-right, the end of the array will be the total product of all before it:
        for(int i = 1; i < size; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        // then, we need a counter to track the product from the right-to-left:
        int rightProduct = 1; // this can jsut be 1. think of it as the end of the array (out-of-bounds) element.
        for(int i = size - 1; i > 0; i--) {
            result[i] *= rightProduct; // multiply all the elements as we traverse from right to left
            rightProduct *= nums[i]; // then update the rightproduct after updating the result (which DID not include the current element)
        }
        result[0] = rightProduct;
        return result;
    }
}  
