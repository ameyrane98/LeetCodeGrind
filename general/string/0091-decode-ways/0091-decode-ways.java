class Solution {
    /**Recursive + memoization */
    int[] t = new int[101];
    public int numDecodings(String s) {
        Arrays.fill(t,-1);
        return solve(s,0);
    }

    public int solve(String s,int i){
        if(i==s.length()){
            return t[i]=1; // on split
        }
        if(s.charAt(i)=='0'){
            return t[i]=0; // on split
        }

        if(t[i]!=-1){
            return t[i];
        }
     
        t[i]=solve(s,i+1);

        if(i+1 < s.length()){
            if(s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'){
                t[i]+= solve(s,i+2);
            }
        }
        

        return t[i];

    }
}