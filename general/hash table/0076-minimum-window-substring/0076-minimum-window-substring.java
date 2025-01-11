import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hMap= new HashMap();
         HashMap<Character,Integer> currWindow= new HashMap();
        for(char c: t.toCharArray()){
            hMap.put(c,hMap.getOrDefault(c,0)+1);
        }

        int left=0;
        int min_length= Integer.MAX_VALUE;
                int min_start = 0;
        for(int right=0; right<s.length(); right++){

            char curr= s.charAt(right);
            currWindow.put(curr,currWindow.getOrDefault(curr,0)+1);

            while(isValid(currWindow,hMap)){
                int lenght= right-left+1;

                if(lenght<min_length){
                    min_length=lenght;
                    min_start=left;
                }
                

                currWindow.put(s.charAt(left),currWindow.get(s.charAt(left))-1);
                if (currWindow.get(s.charAt(left)) == 0) {
                    currWindow.remove(s.charAt(left));
                }
                left++;
            }
            
        }
        System.out.println(min_length);
         return min_length == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min_length);
    }

    public boolean isValid( HashMap<Character,Integer> currWindow, HashMap<Character,Integer> hMap){
        for(Map.Entry<Character,Integer> entry : hMap.entrySet()){
            char key= entry.getKey();
            if(currWindow.getOrDefault(key, 0) <hMap.get(key)){
                return false;
            }
        }

        return true;
    }
}