class Solution {
    // public int majorityElement(int[] nums) {
    //     // HashMap<Integer,Integer> countEle = new HashMap<>();
    //     // int n = nums.length/2;
    //     // for(int i : nums){
    //     //     countEle.put(i,countEle.getOrDefault(i,0)+1);
    //     // }
        
    //     // for(HashMap.Entry<Integer, Integer> entry : countEle.entrySet()){
    //     //     if(entry.getValue()> n){
    //     //        return entry.getKey();
    //     //     }
    //     // }
    //     // return -1;
    // }

    
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Step 1: Find the majority candidate
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // Step 2 (Optional): Verify the candidate if needed
        // This step is not strictly necessary if we assume the array always has a majority element.

        return candidate;
    }


}