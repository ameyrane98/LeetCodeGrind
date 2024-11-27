class Solution {
    List<String> result= new ArrayList();

    public List<String> generateParenthesis(int n) {
        StringBuilder s= new StringBuilder();
        solve(n,s,0,0,0);
        return result;
    }

    void solve(int n,StringBuilder s,int idx, int open, int close){
        if(2*n==s.length()){
            if(isValid(s.toString())){
                result.add(s.toString());
            }
           
            return;
        }
       
       if(open<n){
          s.append("(");
          solve(n,s,idx+1,open+1,close);
          s.deleteCharAt(s.length()-1);
       }
      
        if(close<n){
        s.append(")");
        solve(n,s,idx+1,open,close+1);
        s.deleteCharAt(s.length()-1);
        }
    }

    boolean isValid(String str) {
        int count = 0;

        for(int i=0; i<str.length();i++) {
            if(str.charAt(i) == '(')
                count++;
            else
                count--;
            if(count < 0)
                return false;
        }
        return count==0;
    }
}