class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList();
        StringBuffer sb = new StringBuffer(); 
        solve(n,result,sb);
        return result;
    }

    public void solve(int n, List<String> result,StringBuffer s){
        if(s.length()==2*n){
            if(isValid(s.toString())){
                 result.add(s.toString());
            }
           
            return;
        }

        s.append('(');
        solve(n,result,s);
        s.deleteCharAt(s.length()-1);
        s.append(')');
        solve(n,result,s);
        s.deleteCharAt(s.length()-1);
    }

    public boolean isValid(String s){
        int count =0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
            }
            //count= 1-1-1+1=0; when overall sum is unbalanced immediately resturn 0;
            if(count < 0){
                return false;
            }
        }

        return count==0;
    }
}