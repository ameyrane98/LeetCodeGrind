class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
            - move one element at a time
            - check if this element in present in store
            -  if not update the element
            - if present
                - put the left pointer to right to slide the window
                - get the max length by right-left;
                -clear the hashmap;
            -move to next element
         */
       
          Map<Character, Integer> store = new HashMap<>();
         int maxLength=0;
        int left=0;

         for(int i=0; i<s.length(); i++){
              char c = s.charAt(i);
            if(store.containsKey(c)){
              
                left = Math.max(left, store.get(c) + 1 );
              
            }
            store.put(c, i);
            maxLength=Math.max(maxLength,i-left+1);
         }

         return maxLength;
    }
}