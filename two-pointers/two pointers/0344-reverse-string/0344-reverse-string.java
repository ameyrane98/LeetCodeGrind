class Solution {
    public void reverseString(char[] s) {
        int start=0;
        int end=s.length-1;

        while(start<end){
            //swap start --> end
            char temp= s[end];
            s[end]=s[start];
            s[start]=temp;

            start++;
            end--;
        }

        
    }
}