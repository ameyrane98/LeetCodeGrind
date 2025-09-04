class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] memo = new Integer[m+1][n+1];
        return solve(word1,word2,0,0,m,n,memo);
    }

    public int solve(String s1, String s2, int i, int j, int m, int n,Integer[][] memo){
      

        if (i == m) return n - j;
        // If we reached end of s2, need to delete remaining s1 characters
        if (j == n) return m - i;

        if(memo[i][j]!=null) return memo[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return memo[i][j]=solve(s1,s2,i+1,j+1,m,n,memo);
        }

        int insert= 1+solve(s1,s2,i,j+1,m,n,memo);
        int deletion= 1+solve(s1,s2,i+1,j,m,n,memo);
        int replace= 1+solve(s1,s2,i+1,j+1,m,n,memo);

        return memo[i][j] = Math.min(insert, Math.min(deletion, replace));
    }
}