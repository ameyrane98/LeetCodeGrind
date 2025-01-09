class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
                return false;
            }
        HashMap<Character, Integer> s1Window = new HashMap();
        HashMap<Character, Integer> currWindow = new HashMap();

        for(char c : s1.toCharArray()){
            s1Window.put(c, s1Window.getOrDefault(c,0)+1);
        }
        int left=0;
        
        for(int right=0; right<s2.length() ;right++){
            char curr= s2.charAt(right);
            currWindow.put(curr,currWindow.getOrDefault(curr,0)+1);

            if(right>=s1.length()){
                char outChar = s2.charAt(left);
                 if (currWindow.get(outChar) == 1) {
                        currWindow.remove(outChar);
                } else {
                    currWindow.put(outChar, currWindow.get(outChar) - 1);
                }
                left++;
            }

            if(match(s1Window,currWindow)){
                return true;
            }

        }


        return false;

    }

    public boolean match(HashMap<Character, Integer> h1,   HashMap<Character, Integer> h2){
        return h1.equals(h2);
    }
}