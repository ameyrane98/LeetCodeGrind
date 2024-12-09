class Solution {
    HashMap<Character,Integer> map = new HashMap();
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLength = 0;
        for(int i=0; i<s.length();i++){
        
            while(map.containsKey(s.charAt(i))){
                String sub=s.substring(left,i);
                System.out.println(sub);
                map.remove(s.charAt(left));
                left++;
            }
                
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

}