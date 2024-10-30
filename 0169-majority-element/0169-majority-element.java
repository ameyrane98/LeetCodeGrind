class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> countEle = new HashMap<>();
        int n = nums.length/2;
        for(int i : nums){
            countEle.put(i,countEle.getOrDefault(i,0)+1);
        }
        
        for(HashMap.Entry<Integer, Integer> entry : countEle.entrySet()){
            if(entry.getValue()> n){
               return entry.getKey();
            }
        }
        return -1;
    }
}