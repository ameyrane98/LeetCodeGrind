class Solution {
    // Optimized Approach
//Approach-2 (Sliding Window)
//T.C : O(n)
//S.C : O(1)

    public int takeCharacters(String s, int k) {
        int n = s.length();

        // Count total occurrences of 'a', 'b', and 'c'
        int countA = 0, countB = 0, countC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        // If any character occurs less than `k`, it's impossible to remove `k` instances
        if (countA < k || countB < k || countC < k) {
            return -1;
        }

        // Sliding window variables
        int i = 0, j = 0;
        int notDeletedWindowSize = 0;

        while (j < n) {
            // Reduce count for the character at index `j`
            if (s.charAt(j) == 'a') {
                countA--;
            } else if (s.charAt(j) == 'b') {
                countB--;
            } else if (s.charAt(j) == 'c') {
                countC--;
            }

            // If any count falls below `k`, shrink the window from the left
            while (i <= j && (countA < k || countB < k || countC < k)) {
                if (s.charAt(i) == 'a') {
                    countA++;
                } else if (s.charAt(i) == 'b') {
                    countB++;
                } else if (s.charAt(i) == 'c') {
                    countC++;
                }
                i++;
            }

            // Update the maximum size of the window
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
            j++;
        }

        // Calculate the minimum minutes required (total length - max window size)
        return n - notDeletedWindowSize;
    }

 

  





    /**Sliding Window One appraoch */
    // int result = Integer.MAX_VALUE;

    // void solve(String s, int i, int j, int mintes, int[] freq,int k){
    //     if(freq[0]>=k &&freq[1]>=k && freq[2]>=k){
    //         result=Math.min(result,mintes);
    //         return;
    //     }

    //     if(i>j){
    //         return;
    //     }

    //     // delete from left
    //     int[] arrLeft = freq.clone();
    //     arrLeft[s.charAt(i)-'a']+=1; // udpate the receiving character count
    //     solve(s,i+1,j, mintes+1, arrLeft,k);

        
    //     // delete from right
    //     int[] arrRight = freq.clone();
    //     arrRight[s.charAt(j)-'a']+=1; // udpate the receiving character count
    //     solve(s,i,j-1, mintes+1,arrRight,k);
        
    // }
    // public int takeCharacters(String s, int k) {
    //     int[] arrFreq= new int[3]; // a,b ,c
    //     int minutes=0;
    //     solve(s,0,s.length()-1, minutes,arrFreq,k);
        

    //     return result == Integer.MAX_VALUE ? -1 : result;
    // }


}