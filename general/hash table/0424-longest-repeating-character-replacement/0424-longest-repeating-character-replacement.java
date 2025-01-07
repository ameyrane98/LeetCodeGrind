class Solution {
    public int characterReplacement(String s, int k) {
         int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen; 
        // HashMap<Character,Integer> hmap= new HashMap<>();
        // int left=0;
        // int maxFreq=0;
        // int maxLength=0;

        // for(int right=0; right<s.length(); right++){
        //     //add right char;
        //     hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
        //     maxFreq= Math.max(maxFreq,hmap.get(s.charAt(right)));
        //     int windowLength = right-left+1;
        //     int replacementNeeded=windowLength-maxFreq;

        //     if(replacementNeeded>k){
        //         //remove the left char
        //         hmap.put(s.charAt(left), hmap.get(s.charAt(left)) - 1);
        //         left++;
        //     }

        //     maxLength=Math.max(maxLength,right-left+1);
        // }
     
        // return maxLength;
    }
}