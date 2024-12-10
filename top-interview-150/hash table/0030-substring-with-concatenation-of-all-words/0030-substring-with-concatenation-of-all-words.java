class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> wordMap = new HashMap<>();
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        // Build word frequency map
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate through all possible starting points
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            HashMap<String, Integer> currMap = new HashMap<>();

            // Expand the window by moving the right pointer
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(word)) {
                    currMap.put(word, currMap.getOrDefault(word, 0) + 1);

                    // If word appears more times than expected, adjust the left pointer
                    while (currMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currMap.put(leftWord, currMap.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // If the window size matches, add the left pointer index to the result
                    if (right - left == totalLength) {
                        res.add(left);
                    }
                } else {
                    // Reset the window if the word is not valid
                    currMap.clear();
                    left = right;
                }
            }
        }
        return res;
    }
}
