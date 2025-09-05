class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> s_map= new HashMap<>();
        HashMap<Character,Integer> t_map= new HashMap<>();
        for(char c: s.toCharArray()){
            s_map.put(c,s_map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }

        if(s_map.size()!=t_map.size()){
            return false;
        }

        for(char c: t.toCharArray()){
            if(!s_map.containsKey(c) || !s_map.get(c).equals(t_map.get(c))){
                return false;
            }
        }

        return true;
    }
}