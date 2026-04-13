class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null) return 0 ;
        int n =s.length();
        Set<Character> set = new HashSet<>();
        int max_length = Integer.MIN_VALUE;
        int left = 0;
        for(int i =0; i<n; i++){
            
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));
            max_length= Math.max(max_length, set.size());
        }

        return max_length;
    }
}