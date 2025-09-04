class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> firstIndex= new HashMap();

        int sum=0;
        int max=0;
         firstIndex.put(0, -1);
        for(int i=0; i<nums.length; i++){
            sum+= (nums[i]==1)?1:-1;

            if(firstIndex.containsKey(sum)){
                max= Math.max(max,i-firstIndex.get(sum));
            }else{
                firstIndex.put(sum,i);
            }
        }

        return max;
    }
}