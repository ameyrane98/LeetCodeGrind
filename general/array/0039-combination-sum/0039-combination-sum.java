class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currCombo = new ArrayList();
        solve(currCombo,target,candidates,0);
        return res;
    }

    public void solve(List<Integer> currCombo, int target, int[] candidates,int index){
        if(target < 0 || index==candidates.length){
            return;
        }

        if(target==0){
            if(!res.contains(currCombo)){
                res.add(new ArrayList(currCombo));
            }
           
           return;
        }
   
       

        currCombo.add(candidates[index]);

        solve(currCombo,target-candidates[index],candidates,index+1);
        solve(currCombo,target-candidates[index],candidates, index);

        currCombo.remove(currCombo.size()-1);

        solve(currCombo,target,candidates,index+1);
    }
}