// class Solution {
//     public List<String> generateParenthesis(int n) {

//         /** O(2^n * 2n) */
//         List<String> result= new ArrayList();
//         StringBuffer sb = new StringBuffer(); 
//         solve(n,result,sb);
//         return result;
//     }

//     public void solve(int n, List<String> result,StringBuffer s){
//         if(s.length()==2*n){
//             if(isValid(s.toString())){
//                  result.add(s.toString());
//             }
           
//             return;
//         }

//         s.append('(');
//         solve(n,result,s);
//         s.deleteCharAt(s.length()-1);
//         s.append(')');
//         solve(n,result,s);
//         s.deleteCharAt(s.length()-1);
//     }

//     public boolean isValid(String s){
//         int count =0;
//         for(int i=0; i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 count++;
//             }else{
//                 count--;
//             }
//             //count= 1-1-1+1=0; when overall sum is unbalanced immediately resturn 0;
//             if(count < 0){
//                 return false;
//             }
//         }

//         return count==0;
//     }
// }

/** This is the Optimized version O(2^n) */
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