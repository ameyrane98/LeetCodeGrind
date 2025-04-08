class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map= new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap=
        new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder result= new StringBuilder();
        Map.Entry<Character,Integer> prev= null;

        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> curr= maxHeap.poll();
            result.append(curr.getKey());
            curr.setValue(curr.getValue()-1);

            if(prev!=null && prev.getValue() >0){
                maxHeap.offer(prev);
            }

            prev=curr;
        }

        return result.length()==s.length()? result.toString()  : "";
    }
}