class Solution {
    public int lengthOfLastWord(String s) {
        
        int length=0;
        boolean foundWord = false;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==' '){
                if (foundWord) break;
            }else{
                foundWord = true;
                length++;
            }
        }

        System.out.println(length);
        return length;
    }
}