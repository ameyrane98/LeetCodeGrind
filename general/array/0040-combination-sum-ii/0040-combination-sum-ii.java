class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /**
            Idea:
                Core logic 
                - pick a element, subtract it from target
                - see if we have target==0
                    - yes, we add that combination to list
                    - no, we stil move forwad adding ohter element
         */

        List<Integer> ans = new LinkedList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        solve(candidates,0,n,target,ans);
        return res;
    }

    void solve(int[] candidates,int curr, int n,int target, List<Integer> ans){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target<0 || curr>=n){
            return; 
        }
        
        for(int i=curr ; i<n; i++){
            if(i > curr && candidates[i] == candidates[i-1]) continue;

            ans.add(candidates[i]);
            target-=candidates[i];
            solve(candidates,i+1,n,target,ans);
            ans.remove(ans.size()-1);
            target+=candidates[i];
            
        }
       
        
    }
}