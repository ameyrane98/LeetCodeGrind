class Solution {
    public void rotate(int[] nums, int k) {
       // Circular Queue formula
        int n = nums.length;
        int[] num1 = new int[n];
        for(int i=0; i<n; i++){
            num1[(i+k) % n]= nums[i];
        }
        System.arraycopy(num1,0,nums,0,n);
    }
}