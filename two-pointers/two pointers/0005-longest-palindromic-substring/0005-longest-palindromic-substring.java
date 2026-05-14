

class Solution {
    public String longestPalindrome(String s) {
       int n =s.length();

        int maxLen=Integer.MIN_VALUE;
        int sp=0;
        for(int l=0; l<n; l++){
            for(int r=l; r<n; r++){
                if(solve(s,l,r)){
                    if(r-l+1>maxLen){
                        maxLen= r-l+1;
                        sp=l;
                    }
                 
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }

    public boolean solve(String s, int i, int j){
       if(i>=j){
            return true;
       }

       if(s.charAt(i)==s.charAt(j)){
            return solve(s,i+1,j-1);
       }

        return false;
    }

}