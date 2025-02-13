class Solution {
    List<List<String>> res= new ArrayList();
    
    public List<List<String>> partition(String s) {
        solve(s,0,new ArrayList());
        return res;
    }

    public void solve(String word,int index,List<String> path){
        if(index==word.length()){
            res.add(new ArrayList(path));
            return;
        }

        // Explore all possible partitions
        for (int end = index + 1; end <= word.length(); end++) {
            // If the current substring is a palindrome, add it to the current path
            if (isPalindrome(word, index, end - 1)) {
                path.add(word.substring(index, end));
                // Recur to find other partitions
                solve(word, end, path);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int start, int end){
        if(start>end){
            return true;
        }

        if(str.charAt(start)!= str.charAt(end)){
            return false;
        }

        return isPalindrome(str,start+1,end-1);
    }
}