class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }

    public boolean solve(String s,Set<String> wordDict,int start,Boolean[] memo){
        if(start==s.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for(int end=start+1; end<=s.length(); end++){
            if(wordDict.contains(s.substring(start,end))){
                if(solve(s,wordDict,end,memo)){
                    return memo[start]=true;
                }
            }
           
        }

        return memo[start]=false;
    }
}