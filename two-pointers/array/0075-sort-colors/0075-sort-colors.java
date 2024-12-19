class Solution {
    public void sortColors(int[] nums) {
        /**counting sort */ 

        int[] extra= new int[3];
        
        for(int i=0; i< nums.length; i++){
            extra[nums[i]]+=1;
        }

        int j=0;
        for(int i=0; i<extra.length;i++){
            while(extra[i]>0){
                nums[j]=i;
                j++;
                extra[i]-=1;
            }
        }
    }
}