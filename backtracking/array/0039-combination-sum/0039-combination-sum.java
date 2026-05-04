class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // idea 
        /**
            take any first number
            take first number till that number in les thant target
            move forward to antehr number if it's less than target

            if(target becomes 0, we add the comibation used to answe and try diferent numbe too
            if we reach end of list return ans

            this is typical backtraicking roolbe

            where we try for once number if it works we add to list else we remove the ry and add antoehr numebr just like cubcst problem
         */
        int n = candidates.length;
        List<Integer> ans = new ArrayList<>();
        solve(candidates,target,0,n,ans);
        

        return res;
    }

    void solve(int[] candidates, int target,int currElement,int n,List<Integer> ans){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(target < 0 || currElement>=n ){
            return;
        }
         
        for(int i=currElement; i<n; i++){
            ans.add(candidates[i]);
            target-=candidates[i];
            solve(candidates, target, i, n, ans);
            ans.remove(ans.size()-1);
            target+=candidates[i];
        }
    }
}