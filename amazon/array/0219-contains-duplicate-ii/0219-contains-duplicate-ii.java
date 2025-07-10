class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hset= new HashSet<>();
        for(int i=0; i< nums.length; i++){
            if(hset.contains(nums[i])){
                return true;
            }
            hset.add(nums[i]);
            if(hset.size()>k){
                hset.remove(nums[i-k]);
            }
        }

        return false;
    }
}