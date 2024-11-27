class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr= new ArrayList();
        
        template(nums,arr);
        
        
        return result;
    }

    void template(int[] nums,List<Integer> arr){
        if(arr.size()==nums.length){
            result.add(new ArrayList(arr));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
                template(nums,arr);
                arr.remove(arr.size()-1);
            }
        }

    
    }

}