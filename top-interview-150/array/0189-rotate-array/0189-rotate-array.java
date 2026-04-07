class Solution {
    // public void rotate(int[] nums, int k) {
    //     int n= nums.length;
    //     int[] res = new int[n];

    //     for(int i=0; i < n ; i++){
    //         int pos = (i + k) % n;
    //         res[pos]= nums[i];
    //     }


    //   System.arraycopy(res, 0, nums, 0, n); 
    // }


    public void rotate(int[] nums, int k) {
        int n= nums.length;
         k = k % n;

        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]= temp;
    }
}