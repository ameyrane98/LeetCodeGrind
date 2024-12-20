class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack();

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(' ||s.charAt(i)=='{' || s.charAt(i)=='['){
                stck.push(s.charAt(i));
            }else{
                if (stck.isEmpty()) {
                    return false;
                }

                char top = stck.pop(); // Pop the top element
                
                // Check for matching pairs
                if ((s.charAt(i) == ')' && top != '(') || 
                    (s.charAt(i) == '}' && top != '{') || 
                    (s.charAt(i) == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stck.isEmpty();
    }
}