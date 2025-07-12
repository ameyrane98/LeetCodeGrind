class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hMap= new HashSet();
        int left=0;
        int slength=0;
        int maxLength=0;
        for(int right=0; right<s.length(); right++){

            while(hMap.contains(s.charAt(right))){
                System.out.println(s.substring(left,right));
                hMap.remove(s.charAt(left));
                left++;
            }

            hMap.add(s.charAt(right));
            slength=right-left+1;
          
            maxLength=Math.max(maxLength,slength);

        }

        return maxLength;
    }
}