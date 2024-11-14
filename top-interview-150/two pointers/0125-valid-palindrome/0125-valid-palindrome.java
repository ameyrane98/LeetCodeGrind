class Solution {
    public boolean isPalindrome(String s) {
     
        s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        int start=0;
        int end=s.length()-1;
      

        while(start<end){
            if(s.charAt(start) == s.charAt(end) ){
                start+=1;
                end-=1;
            }else{
                return false;
            }
        }

        return true;
    }
}