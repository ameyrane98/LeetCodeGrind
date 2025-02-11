class TrieNode{
    TrieNode[] children= new TrieNode[26];
    boolean isEnd=false;
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root= new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int idx= c-'a';

            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node = node.children[idx];
        } 

        node.isEnd=true;
    }
    
    public boolean search(String word) {
        return searchUtil(word,root);
    }

    public boolean searchUtil(String word,TrieNode root){
        TrieNode node= root;

        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);

            int index= ch-'a';
            if(ch=='.'){
                for(int j=0; j<26; j++){
                    if(node.children[j]!=null){
                        if(searchUtil(word.substring(i+1),node.children[j]) == true){
                            return true;
                        }
                    }
                }

                return false;
            }else if(node.children[index]== null){
                return false;
            }

            node= node.children[index];
        }

        return node.isEnd;
    }
    
    
   
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */