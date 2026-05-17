class Solution {
    public int minRemoval(int[] nums, int k) {

        int n = nums.length;

        if(n==1){
            return 0;
        }
        Arrays.sort(nums);
        int i=0;int j=0;
        int maxWindow =0;
        while(j<n){

            if((long)nums[j]<= (long)k* nums[i]){
                j++;
                 maxWindow = Math.max(maxWindow, j - i);
            }else{
                i++;
            }
        }

        return n- maxWindow; 
    }
}