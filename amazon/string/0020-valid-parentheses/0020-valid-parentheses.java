class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stck.push(c);
            }
            if (stck.isEmpty()) return false;
            if(c==')'){
                if(stck.pop()!='('){
                    return false;
                }
            }else if(c=='}'){
                if(stck.pop()!='{'){
                    return false;
                }
            }else if(c==']'){
                if(stck.pop()!='['){
                    return false;
                }
            }
        }
        

        return stck.isEmpty();
    }
}