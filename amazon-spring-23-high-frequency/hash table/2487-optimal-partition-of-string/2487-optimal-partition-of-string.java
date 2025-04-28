class Solution {
    public int partitionString(String s) {
        int count=1;
        int[] freq = new int[26];
        Arrays.fill(freq,0);
        

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            
            if (freq[index] == 1) {
                // character already seen, so start a new partition
                count++;
                Arrays.fill(freq, 0); // reset the freq array for new partition
            }
            
            freq[index] = 1; // mark character as seen
        }

        return count;
    }
}