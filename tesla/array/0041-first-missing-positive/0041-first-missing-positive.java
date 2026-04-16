class Solution {
    public int firstMissingPositive(int[] nums) {
        // unsorted nums
        // smallest positive element not present in nums
        // nums = [1,2,0] ans=3   0 -> 1-> 2 
        // nums = [3,4,-1,1]   -5 -> -4 -> 1  -> 2  -> 5 
        

        HashSet<Integer> set = new HashSet<>();
        int n =nums.length;
        for(int i : nums){
            set.add(i);
        }

        for(int i =1; i<= n+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return n+1;
    }
}