class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // [-4,-2,-1,0,1,2]
        //initial n1=4 i.e idx=0

        for(int i=0; i<nums.length-2; i++){
            // nums.length-2  i.e [startPos of n1,-2,-1,0,1,2] till [-4,-2,-1,end pos of n1,1,2]
            if(i>0 && nums[i]==nums[i-1]){
                continue; // skip duplicate element for n1
            }
            // now lets do twoSum for n2 and n3 to find -n1 i.e n1+n2+n3=0 n1+n2=-n3
            //  [-4 (n1),-2 (n2),-1,0,1,2 (n3)] doing two sum from n2 to n3 to find n2+n3= -n1
            int left = i+1 ;// n2
            int right= nums.length-1;

            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];

                if(sum==0){
                    result.add(Arrays.asList(nums[left],nums[right],nums[i]));

                    while(left<right && nums[left]==nums[left+1]){
                        left++;  // to check duplicate number for left idx
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;  // to check duplicate number for right idx
                    }

                    left++;
                    right--;
                }else if(sum<0){
                    left++;//sum is negative so we need to add a biger number because our nums is sorted
                }else{
                    right--; // if sum to big, reduce a number/ add small number
                }

            }

           
        }
         return result;
    }
}