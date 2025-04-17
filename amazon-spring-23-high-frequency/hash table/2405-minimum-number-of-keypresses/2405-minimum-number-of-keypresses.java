class Solution {
    public int minimumKeypresses(String s) {
        int[] freq= new int[26];
       for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Convert to list and sort in descending order
        Integer[] freqList = new Integer[26];
        for (int i = 0; i < 26; i++) {
            freqList[i] = freq[i];
        }

        Arrays.sort(freqList, (a, b) -> b - a); // descending sort

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (freqList[i] == 0) break;
            int keypress = (i / 9) + 1;
            result += freqList[i] * keypress;
        }

        return result;
    }
    
}