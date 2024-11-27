class Solution {
    List<String> result= new ArrayList();

    public List<String> generateParenthesis(int n) {
        StringBuilder s= new StringBuilder();
        solve(n,s,0);
        return result;
    }

    void solve(int n,StringBuilder s,int idx){
        if(2*n==s.length()){
            if(isValid(s.toString())){
                result.add(s.toString());
            }
           
            return;
        }
       
        s.append("(");
        solve(n,s,idx+1);
        s.deleteCharAt(s.length()-1);

        s.append(")");
        solve(n,s,idx+1);
        s.deleteCharAt(s.length()-1);
       
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