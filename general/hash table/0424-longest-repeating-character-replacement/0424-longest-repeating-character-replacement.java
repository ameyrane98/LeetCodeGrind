class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hmap= new HashMap<>();
        int left=0;
        int maxFreq=0;
        int maxLength=0;

        for(int right=0; right<s.length(); right++){
            //add right char;
            hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
            maxFreq= Math.max(maxFreq,hmap.get(s.charAt(right)));
            int windowLength = right-left+1;
            int replacementNeeded=windowLength-maxFreq;

            if(replacementNeeded>k){
                //remove the left char
                hmap.put(s.charAt(left), hmap.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength=Math.max(maxLength,right-left+1);
        }
     
        return maxLength;
    }
}