class Solution {
    public void rotate(int[] nums, int k) {
       // Circular Queue formula
         //    //i+k % n
        // int n = nums.length;
        // int[] num1 = new int[n];
        // for(int i=0; i<n; i++){
        //     num1[(i+k) % n]= nums[i];
        // }
        // System.arraycopy(num1,0,nums,0,n);

        // Another Approach
        k = k % nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;

            left++;
            right--;
        }
    }
}