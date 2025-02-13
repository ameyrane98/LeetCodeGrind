class Solution {
    List<List<Integer>>  res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums,0,new ArrayList());
        return res;
    }

    public void solve(int[] nums,int idx, List<Integer> arr){
        if(idx==nums.length){
            if(!res.contains(arr)){
                res.add(new ArrayList(arr));
            }
          
            return;
        }

        arr.add(nums[idx]);
        solve(nums,idx+1, arr);
        arr.remove(arr.size()-1);
        solve(nums,idx+1, arr);
    }
}