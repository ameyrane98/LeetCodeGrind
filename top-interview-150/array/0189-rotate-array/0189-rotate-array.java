class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        int[] res = new int[n];

        for(int i=0; i < n ; i++){
            int pos = (i + k) % n;
            res[pos]= nums[i];
        }


      System.arraycopy(res, 0, nums, 0, n); 
    }
}