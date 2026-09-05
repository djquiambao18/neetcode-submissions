class NumArray {
    int[] prefixSum;
    int sum;
    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length];
        sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int prefixRight = prefixSum[right];
        int prefixLeft = 0;
        if(left > 0) {
            prefixLeft = prefixSum[left - 1];
        }
        return prefixRight - prefixLeft;    
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */