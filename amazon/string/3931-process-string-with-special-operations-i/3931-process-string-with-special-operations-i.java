class Solution {
    public String processStr(String s) {
        if(s.equals("")){
            return s;
        }

        StringBuilder result= new StringBuilder();
       
        for(char c : s.toCharArray()){
            
            if(c=='*'){
                if(!result.isEmpty()){
                    result.delete(result.length()-1,result.length());
                }
               
            }else if(c=='#'){
               String newStr= result.toString();
               result.append(newStr);

            }else if(c=='%'){
                result.reverse();
            }else{
                result.append(c);
            }
            
            
        }

        return result.toString();
    }
}