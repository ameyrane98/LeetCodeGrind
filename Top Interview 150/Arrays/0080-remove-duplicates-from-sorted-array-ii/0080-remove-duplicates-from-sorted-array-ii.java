class Solution {
    public int removeDuplicates(int[] nums) {

         if (nums.length == 0) {
            return 0; // Handle empty array case
        }
        int pivot = nums[0];
        int eleCount= 1;
        int index =1; // first element is always unique

        for(int i=1; i<nums.length; i++){
            
            if(nums[i]==pivot && eleCount <2){
                nums[index] = nums[i];// place element  in front if it's in the coutn limit
                index++;
                eleCount+=1;
            }else if(nums[i]!=pivot){
                nums[index]=nums[i];
                pivot=nums[i];
                eleCount=1;
                index++;
           
            }else{
                continue;
            }
            
        }

        return index;
    }
}