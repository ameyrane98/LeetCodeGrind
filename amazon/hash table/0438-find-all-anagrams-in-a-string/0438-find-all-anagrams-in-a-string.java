class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /**

            if the array p is bigger than s return result

            if i>=m:
                remove the first elememt usning i-m;

            if i==m:
                compare two arrays
         */

         List<Integer> res = new ArrayList<>();
         if(p.length()>s.length()) return res;
        int m = p.length();
         int[] sCount= new int[26];
         int[] pCount= new int[26];

         for(char c : p.toCharArray()){
            pCount[c-'a']++;
         }

         for(int i=0; i<s.length(); i++){
             sCount[s.charAt(i)-'a']++;

             if(i>=m){
                sCount[s.charAt(i-m)-'a']--;
             }

             if(i>=m-1 && Arrays.equals(sCount, pCount)){
                res.add(i-m+1);
             }


         }

         return res;
    }
}