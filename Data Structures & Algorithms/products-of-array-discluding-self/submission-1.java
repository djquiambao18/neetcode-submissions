class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force:
        // 1. at the current index, start a for-loop, and cycle through the length of the list.
        // 1a. use the modulo operator to loop around, but stop when we reach the beginning (size - 1)
        // guaranteed at least 2 numbers up to 1000 numbers
        // each number can be between -20 and 20
        // time complexity is O(nums.length^2)
        // space complexity is O(1).
        // int n = nums.length;
        // int[] result = new int[n];
        // for(int i = 0; i < n; i++) {
        //     // at the beginning of each item, we start another loop, skipping the current element
        //     // termination: when we've reached the beginning (use an intermediate number called steps)
        //     // we'll know when we've cycled when step == n - 1;
        //     int step = 0;
        //     int product = 1; // unit-value, if 0 everything will be 0.
        //     for(int j = i + 1; step < n; j++) {
        //         product *= nums[j%n];
        //     }
        //     result[i] = product;
        // }
        // return result;

        // Sol'n 2: 
        int size = nums.length;
        int[] result = new int[size];
        // initialize the first input as 1
        // nums[1,2,4,6] or nums[-1,0,1,2,3]
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
