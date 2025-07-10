class Solution {
    public int[] twoSum(int[] nums, int target) {
        // o(n2)
        // int n=nums.length;
        // int[] ans= new int[2];

        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i]+nums[j]==target){
        //             ans[0]=i;
        //             ans[1]=j;
        //         }
        //     }
        // }



        // return ans;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement= target-nums[i];
            if(hmap.containsKey(complement)){
                return new int[]{hmap.get(complement),i};
            }
            hmap.put(nums[i],i);
        }
       
        return new int[]{-1,-1};
    }
} 