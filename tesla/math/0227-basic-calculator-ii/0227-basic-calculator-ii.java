class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        char prevOP= '+';
        int lasTerm= 0;
        int currNumber = 0;
        int totalresult=0;

        for(int i=0; i<s.length();i++){
            char currChar = s.charAt(i);


            if(Character.isDigit(currChar)){
                currNumber = (currNumber * 10) + (currChar - '0');
            }


            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1){
                if(prevOP=='+'){
                    totalresult+=lasTerm;
                    lasTerm = currNumber;
                    
                }else if(prevOP=='-'){
                    totalresult+=lasTerm;
                    lasTerm=-currNumber;
                }else if(prevOP=='*'){
                    lasTerm=lasTerm*currNumber;
                }else if(prevOP=='/'){
                    lasTerm=lasTerm/currNumber;
                }

                 prevOP=currChar;
                currNumber=0;
                
            }
        
        }

        return totalresult+lasTerm;
    }
}