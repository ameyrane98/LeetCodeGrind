class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) return new int[0];
    
    int[] left = new int[n];
    int[] right = new int[n];
    int[] res = new int[n - k + 1];
    
    // Fill left array
    for (int i = 0; i < n; i++) {
        if (i % k == 0) left[i] = nums[i];  // Start of a block
        else left[i] = Math.max(left[i - 1], nums[i]);
    }
    
    // Fill right array
    for (int i = n - 1; i >= 0; i--) {
        if (i == n - 1 || (i + 1) % k == 0) right[i] = nums[i];  // End of a block
        else right[i] = Math.max(right[i + 1], nums[i]);
    }
    
    // Compute maximums for each window
    for (int i = 0; i <= n - k; i++) {
        res[i] = Math.max(right[i], left[i + k - 1]);
    }
    
    return res;
}



    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int left=0;
    //     int right =0;
    //     int[] res= new int[nums.length-k+1];
    //     int idx=0;
    //     while(right<nums.length+1){
          
    //         if(right-left>=k){
    //             int[] arr= Arrays.copyOfRange(nums,left,right);
    //             res[idx]=giveMax(arr);
    //             idx++;
    //             left++;
    //         }
          
    //         right++;
           
    //     }

    //     return res;
    // }

    // public int giveMax(int[] arr){
    //     Arrays.sort(arr);
    //     return arr[arr.length-1];
    // }
}