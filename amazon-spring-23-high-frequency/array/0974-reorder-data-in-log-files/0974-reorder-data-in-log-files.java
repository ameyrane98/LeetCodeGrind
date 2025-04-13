

import static java.lang.Character.isDigit;

class Solution {
    Queue<String> digitLogs= new LinkedList<>();
    ArrayList<String> letterLogs = new ArrayList<>();
    public String[] reorderLogFiles(String[] logs) {
        
        for(int i=0; i<logs.length; i++){

            if(checkDigiLogs(logs[i])){
                digitLogs.add(logs[i]);
            }else{
                letterLogs.add(logs[i]);
            }

          
           
        }

       letterLogs.sort((a, b) -> {
            String[] splitA = a.split(" ", 2);
            String[] splitB = b.split(" ", 2);
            int cmp = splitA[1].compareTo(splitB[1]);
            if (cmp != 0) {
                return cmp; // Compare content
            }
            return splitA[0].compareTo(splitB[0]); // Tie-breaker: compare identifiers
        });

        // Combine result
        List<String> result = new ArrayList<>();
        result.addAll(letterLogs);
        result.addAll(digitLogs);

        return result.toArray(new String[0]);
    }
    public boolean checkDigiLogs(String s){
        String[] data =s.split(" ");
        if(isDigit( data[1].charAt(0))){
            return true;
        }
        return false;
    }
}