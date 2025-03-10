class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] mp = new int[26];
        int time=0;
        for(char c : tasks){
            mp[c-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for(int i=0; i<26; i++){
            if(mp[i]>0){
                pq.offer(mp[i]);
            }
        }
       

        while(!pq.isEmpty()){

            ArrayList<Integer> temp= new ArrayList();
            int cycle = Math.min(n + 1, pq.size());
            for(int i=0; i<cycle; i++){
                if(!pq.isEmpty()){
                    int freq= pq.peek();
                    pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for(int freq: temp){
                if(freq>0){
                    pq.offer(freq);
                }
            }

            if(pq.isEmpty()){
                time+=temp.size();
            }else{
                time+=n+1;
            }
        }

        return time;
    }
}