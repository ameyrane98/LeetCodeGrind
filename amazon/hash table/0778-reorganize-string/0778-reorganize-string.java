class Solution {
    //O(n log k)
    // public String reorganizeString(String s) {
    //     HashMap<Character,Integer> map= new HashMap<>();

    //     for(int i=0; i<s.length(); i++){
    //         map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
    //     }

    //     PriorityQueue<Map.Entry<Character,Integer>> maxHeap=
    //     new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

    //     maxHeap.addAll(map.entrySet());

    //     StringBuilder result= new StringBuilder();
    //     Map.Entry<Character,Integer> prev= null;

    //     while(!maxHeap.isEmpty()){
    //         Map.Entry<Character,Integer> curr= maxHeap.poll();
    //         result.append(curr.getKey());
    //         curr.setValue(curr.getValue()-1);

    //         if(prev!=null && prev.getValue() >0){
    //             maxHeap.offer(prev);
    //         }

    //         prev=curr;
    //     }

    //     return result.length()==s.length()? result.toString()  : "";
    // }

    /** Optimal Approach  */
    public String reorganizeString(String s) {
        int[] freq= new int[26];
    
        int n= s.length();
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
      
       
        //exit if maxFrequency is more than allocated space length
        int maxFreq = 0, maxCharIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxCharIndex = i;
            }
        }
          if (maxFreq > (n + 1) / 2) return "";
        char[] result= new char[n];
        int idx=0;

        while(freq[maxCharIndex]>0){
            result[idx]=(char) (maxCharIndex+'a');
            idx+=2;
            freq[maxCharIndex]--;
        }


        for(int i=0; i<26; i++){
           while(freq[i] >0){
             if (idx >= n) idx = 1; 
            result[idx]= (char) (i+'a');
            idx+=2;
            freq[i]--;
           }
        }


        return new String(result);
    }

}