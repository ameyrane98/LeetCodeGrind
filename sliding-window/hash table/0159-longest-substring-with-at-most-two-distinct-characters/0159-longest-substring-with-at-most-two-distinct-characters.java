class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int max =0;
        int left =0;
        for(int i =0; i<s.length(); i++){
           char c = s.charAt(i);
           hmap.put(c,hmap.getOrDefault(c,0)+1);
            // when b comes e=2 c=2
            while(hmap.size()>2){
                //remove the left most character
                hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                if (hmap.get(s.charAt(left)) == 0) {
                    hmap.remove(s.charAt(left));
                }

                left++;
            }

            max = Math.max(max,i-left+1);
           
        }

        return max;
    }
}