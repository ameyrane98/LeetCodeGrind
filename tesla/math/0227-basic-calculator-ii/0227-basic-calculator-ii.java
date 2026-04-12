class Solution {
    public int calculate(String s) {
        if(s== null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int currNumber= 0;
        char prevOperation= '+';

        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);

            if(Character.isDigit(currChar)){
                currNumber= (currNumber * 10) + (currChar - '0');
            } 

            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length() - 1)
            {
                if(prevOperation=='+'){
                    stack.push(currNumber);
                }else if(prevOperation=='-'){
                    stack.push(-currNumber);
                }else if(prevOperation=='*'){
                    stack.push(stack.pop() * currNumber);
                }else if(prevOperation=='/'){
                    stack.push(stack.pop() / currNumber);
                }

                prevOperation=currChar;
                currNumber=0;
            }
        }

        
    

       int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }

        
    
}