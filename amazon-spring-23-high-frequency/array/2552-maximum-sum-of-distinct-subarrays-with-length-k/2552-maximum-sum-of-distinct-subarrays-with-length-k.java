class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n= nums.length;
        if (n < k) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        long windowSum=0;
        int left=0;
        long maxSum=0;
        for(int right=0; right<n ; right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            windowSum+=nums[right];

            if(right-left+1 >k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                
                windowSum-=nums[left];  

                left++;
            }

            if(right-left+1==k && map.size()==k){
                maxSum= Math.max(windowSum,maxSum);
            }
         }

        return maxSum;
    }
}