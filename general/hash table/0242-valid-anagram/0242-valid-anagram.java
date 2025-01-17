class Solution {
    public boolean isAnagram(String s, String t) {
        /**Appraoch 1 */
        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();
        
        // Arrays.sort(sChars);
        // Arrays.sort(tChars);
        
        // return Arrays.equals(sChars, tChars);

         /**Appraoch 2 */
        //  Map<Character, Integer> count = new HashMap<>();
        
        // // Count the frequency of characters in string s
        // for (char x : s.toCharArray()) {
        //     count.put(x, count.getOrDefault(x, 0) + 1);
        // }
        
        // // Decrement the frequency of characters in string t
        // for (char x : t.toCharArray()) {
        //     count.put(x, count.getOrDefault(x, 0) - 1);
        // }
        
        // // Check if any character has non-zero frequency
        // for (int val : count.values()) {
        //     if (val != 0) {
        //         return false;
        //     }
        // }
        
        // return true;

        /**Appraoch 3 */
      int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;

    }
}