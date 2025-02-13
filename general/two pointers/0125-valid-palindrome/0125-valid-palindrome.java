class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder str= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i))||Character.isDigit(s.charAt(i))){
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(str);
        return checkPalindrome(str.toString(), 0, str.length()-1);
    }

    public boolean checkPalindrome(String st,int start, int end){
        if(start>end){
            return true;
        }

        if(st.charAt(start)!=st.charAt(end)){
            return false;
        }
       
        return checkPalindrome(st,start+1,end-1);
    }
}