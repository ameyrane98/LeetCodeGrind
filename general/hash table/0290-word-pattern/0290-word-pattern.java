class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] word = s.split(" ");

        if(pattern.length()!= word.length){
            return false;
        }

        HashMap<Character,String> c2W = new HashMap<>();
        HashMap<String,Character> W2c = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            Character c = pattern.charAt(i);
            String w = word[i];

            if(c2W.containsKey(c) && !c2W.get(c).equals(w)){
                return false;
            }
            if (W2c.containsKey(w) && W2c.get(w)!=c){
                return false;
            }
            c2W.put(c,w);
            W2c.put(w,c);
        }

        return true;
    }
}