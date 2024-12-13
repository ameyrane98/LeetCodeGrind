class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    /**Approach 1*/
       HashMap<String,List<String>> map= new HashMap();


            
        for(String c : strs){
            char[] charArray= c.toCharArray();
            Arrays.sort(charArray);
            String sortedString= new String(charArray);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(c);
        }

        

         // Return all values from the map as a list of lists
        return new ArrayList<>(map.values());

    /**Approach 2*/
    //   HashMap<String, List<String>> map = new HashMap<>();

    // for (String s : strs) {
    //     int[] count = new int[26];
    //     for (char c : s.toCharArray()) {
    //         count[c - 'a']++;
    //     }

    //     // Create a unique key from the character counts
    //     StringBuilder keyBuilder = new StringBuilder();
    //     for (int i = 0; i < 26; i++) {
    //         keyBuilder.append('#').append(count[i]);
    //     }
    //     String key = keyBuilder.toString();

    //     map.putIfAbsent(key, new ArrayList<>());
    //     map.get(key).add(s);
    // }

    // return new ArrayList<>(map.values());
    }


}