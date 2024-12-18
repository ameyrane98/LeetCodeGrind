class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase
        s = s.toLowerCase();
        
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
           // Skip non-alphanumeric characters from the start
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            
            // Skip non-alphanumeric characters from the end
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            
            // Check if the characters at start and end are the same
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
    /**Approach 1 */
    // s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    //     System.out.println(s);
    //     int start=0;
    //     int end=s.length()-1;
      

    //     while(start<end){
    //         if(s.charAt(start) == s.charAt(end) ){
    //             start+=1;
    //             end-=1;
    //         }else{
    //             return false;
    //         }
    //     }

    //     return true;
}
