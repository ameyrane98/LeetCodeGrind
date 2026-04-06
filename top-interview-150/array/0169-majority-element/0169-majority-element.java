
import java.security.KeyStore.Entry;class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int ele : nums){
        //     map.put(ele, map.getOrDefault(ele, 0)+1);
        // }
        // int maxOccur= 0;
        // int majorityElement = nums[0];
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(maxOccur < entry.getValue()){
        //         maxOccur= entry.getValue();
        //         majorityElement = entry.getKey();
        //     }
         
        // }
        

        // return majorityElement;

        //boyes Voter Algo
        int candidate = nums[0];
        int count = 0;

        for(int ele : nums){
            if(count==0){
                candidate=ele;
            }
            if(ele==candidate){
                count++;
            }else{
                count--;
            }
        }

        return candidate;
    }
}