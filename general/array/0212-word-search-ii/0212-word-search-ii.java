class TrieNode{
    TrieNode[] next= new TrieNode[26];
    String word;
}



class Solution {
        public List<String> findWords(char[][] board, String[] words) { 
            TrieNode root= buildTree(words);
            List<String> res= new ArrayList();
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    dfs(board,i,j,root,res);
                }
            }

            return res;
        }

        public TrieNode buildTree(String[] words){
            TrieNode node= new TrieNode();
            for(String word : words){
                 TrieNode p = node;
                for(char ch : word.toCharArray()){
                    int idx= ch-'a';
                    if(p.next[idx]==null){
                        p.next[idx]= new TrieNode();
                    }
                    p=p.next[idx];
                }

                p.word=word;
            }

            return node;
        }
        

        public void dfs(char[][] board, int i, int j,TrieNode p,List<String> res){
            char c = board[i][j];
            int idx= c-'a';
            // if next is null
            if(c=='#'|| p.next[idx]==null){
                return;
            }
            p=p.next[idx];// move to next node
            // reach the last character in word
            if(p.word!=null){
                res.add(p.word);
                p.word=null;
            }
      
            board[i][j]='#';

            if(i>0) dfs(board, i-1, j, p, res);
            if(j>0) dfs(board, i, j-1, p, res);
            if(i<board.length-1) dfs(board, i+1, j, p, res);
            if(j<board[0].length-1) dfs(board, i, j+1, p, res);

            board[i][j]=c;
        }










    //one way to do it but it's ineffcient if the words.length is to high
    // public List<String> findWords(char[][] board, String[] words) {
        
         
    //     Set<String> foundWords = new HashSet<>();

    //     for (String word : words) { // Iterate over each word
    //         for (int i = 0; i < board.length; i++) { // Iterate over rows
    //             for (int j = 0; j < board[0].length; j++) { // Iterate over columns
    //                 if (board[i][j] == word.charAt(0)) { // If first letter matches
    //                     if (dfs(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
    //                         foundWords.add(word); // Add found word
    //                     }
    //                 }
    //             }
    //         }
    //     }
   
    //     return new ArrayList(foundWords);
    // }

    // public boolean dfs(char[][] board, int row, int col,String word,int index, boolean[][] visited){
    //     // Base case: entire word is found
    //     if (index == word.length()) {
    //         return true;
    //     }
    //     // Check boundaries and if cell is already visited or doesn't match
    //     if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
    //         visited[row][col] || board[row][col] != word.charAt(index)) {
    //         return false;
    //     }

    //     // Mark cell as visited
    //     visited[row][col] = true;

    //     // Explore all 4 directions (up, down, left, right)
    //     boolean found = dfs(board, row + 1, col, word, index + 1, visited) ||
    //                     dfs(board, row - 1, col, word, index + 1, visited) ||
    //                     dfs(board, row, col + 1, word, index + 1, visited) ||
    //                     dfs(board, row, col - 1, word, index + 1, visited);

    //     // Backtrack: unmark cell before returning
    //     visited[row][col] = false;
    //     return found;
    // }
}