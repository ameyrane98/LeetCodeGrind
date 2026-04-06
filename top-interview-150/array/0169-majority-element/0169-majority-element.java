class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int maxOccur= 0;
        int majorityElement = nums[0];
        for(int ele : nums){
            if(maxOccur < map.get(ele)){
                maxOccur= map.get(ele);
                majorityElement = ele;
            }
         
        }
        

        return majorityElement;
    }
}