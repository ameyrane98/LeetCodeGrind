class Solution {
    List<List<String>> result= new ArrayList();
    public List<List<String>> groupAnagrams(String[] strs) {
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
    }
}