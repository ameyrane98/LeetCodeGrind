class Solution {
    List<List<Integer>> set=new ArrayList();
    List<Integer> subset=new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        
        solve(nums,subset,0);
        return set;
    }

    void solve(int[] nums,List<Integer> subset,int idx){
        if(idx==nums.length){
         
                set.add(new ArrayList<>(subset));
            
      
            return;
        }

  

        subset.add(nums[idx]);
        solve(nums,subset,idx+1);
        subset.remove(subset.size()-1);
        solve(nums,subset,idx+1);
    }
}