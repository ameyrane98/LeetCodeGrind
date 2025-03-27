class Solution {
    /*** Recursion + Memoization */
    public String longestPalindrome(String s) {
        int n= s.length();
       
        int maxLen= Integer.MIN_VALUE;
        int sp=0; int ep= 0;

        for(int i=0; i < n ; i++){
            for(int j=i ;j < n ; j++){
                  if(isPalindrome(s,i,j)){
                        if(j-i+1 > maxLen){
                             maxLen = j-i+1;
                            sp=i;
                            ep=j;
                        }
                       
                }
            }
        }
      
       
       
        return s.substring(sp, ep+1);
    }

    boolean isPalindrome(String s, int start, int end){
        if(start>=end){
            return true;
        }

        if(s.charAt(start)==s.charAt(end)){
            return isPalindrome(s,start+1,end-1);
        }

        return false;
    }
}