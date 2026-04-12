class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        List<List<Integer>> res= new ArrayList<>();

        for(int i =0; i< n-2; i++){
            int j = i+1;
            int k = n-1;
           if(i> 0 && nums[i]==nums[i-1]){
                continue;
           }
            while(j<k){
               
                int sum = nums[i]+ nums[k]+ nums[j];

                if( sum ==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    
                    j++; // FIXED: Move both to find next potential pair
                    k--;                    
                }else if(sum < 0){
                    j++;
                }else {
                     k--;
                }
                
            }
        
        }

        return res;
    }
}