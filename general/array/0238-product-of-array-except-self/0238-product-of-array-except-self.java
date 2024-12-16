class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize result with prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Compute suffix products and update result
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
        /**Appraoch 1 */
        // int n = nums.length;
        // int[] result= new int[n];


        // //left multiply
        // int leftProduct=1;
        // for(int i=0; i<n;i++){
        //     result[i]=leftProduct;
        //     leftProduct*=nums[i]; //{_,2,3,4}=> 1*1;
        // }

        // //right multiply

        // int rightProduct=1;
        // for(int i=n-1; i>=0;i--){
        //     result[i]*=rightProduct;
        //     rightProduct*=nums[i]; //{_,2,3,4}=> 1*1;
        // }

        // return result;
    }
}