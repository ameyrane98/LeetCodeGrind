class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap= new HashMap<>();
        hmap.put(0,1); // sum of 0 has already occured
        int prefixSum=0;
        int count= 0;

        for(int i=0; i<nums.length; i++){
            prefixSum+=nums[i];
            if(hmap.containsKey(prefixSum-k)){
                count+=hmap.get(prefixSum-k);
            }

            hmap.put(prefixSum,hmap.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}