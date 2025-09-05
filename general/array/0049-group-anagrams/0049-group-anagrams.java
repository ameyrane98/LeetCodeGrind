class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> store = new HashMap();

        /** we have to store a unique stirng ket for each word */

        for(String str: strs){
            // store word in int[26]
            int[] pos= new int[26];
            for (int i = 0; i < str.length(); i++) {
                pos[str.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int c : pos) {
                key.append('#').append(c);
            }
            String k = key.toString();
            List<String> list = store.get(k);
            if (list == null) {
                list = new ArrayList<>();
                store.put(k, list);
            }
            
            store.get(k).add(str);

        }

       return new ArrayList<>(store.values());
    }
}