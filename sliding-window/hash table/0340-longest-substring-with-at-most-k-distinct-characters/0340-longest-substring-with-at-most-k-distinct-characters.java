class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> hmap= new HashMap<>();
        int left=0;
        int max =0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            hmap.put(c,hmap.getOrDefault(c, 0)+1); // hmap e->2

            if(hmap.size()>k){
                // then we need to remove the leftmost elements 
                while(hmap.size()>k){
                    char leftChar =s.charAt(left);
                    hmap.compute(leftChar, (t,v) -> v==1? null : v-1);
                    left++;
                }
            }

            max= Math.max(max,i-left+1);
        }


        return max;
    }   
}