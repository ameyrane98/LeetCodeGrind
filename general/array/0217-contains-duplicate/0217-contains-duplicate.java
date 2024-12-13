class Solution {
    public boolean containsDuplicate(int[] nums) {
    /**Approach 2 */
    Arrays.sort(nums);

    for(int i=1; i<nums.length; i++){
        if(nums[i-1]==nums[i]){
            return true;
        }
    }
    

    /**Approach 1 */
    //    HashMap<Integer, Integer> map = new HashMap();

    //    for(int i=0; i<nums.length; i++){
    //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);

    //     if(map.get(nums[i])>1){
    //         return true;
    //     }
    //    }


       return false;
    }
}