class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();

        que.add(beginWord);
        int level = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String word1 = que.remove();
                for (String word2 : wordList) {
                    if (wordSet.contains(word2) && isOneletterDiff(word1, word2)) {
                        if (word2.equals(endWord)) return level + 1;
                        que.add(word2);
                        wordSet.remove(word2);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public boolean isOneletterDiff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }
        return diffCount == 1;
    }
}
