class Solution {
    public int firstUniqChar(String s) {
       int[] charArr= new int[26];
        Arrays.fill(charArr,0);
       for(char c: s.toCharArray()){
            charArr[c-'a']+=1;
       }

        for(int i=0; i<s.length(); i++){
            if(charArr[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return -1;
    }
}