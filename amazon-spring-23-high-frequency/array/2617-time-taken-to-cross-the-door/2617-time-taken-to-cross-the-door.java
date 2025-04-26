class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer> entryQue= new LinkedList<>();
        Queue<Integer> exitQue= new LinkedList<>();
        int n=arrival.length;
        int time=0;
        int i=0; // points to the person
        int lastState=1; // assumme previous person exit;
        int[] ans = new int[n];
        while(i<n || !entryQue.isEmpty() || !exitQue.isEmpty()){
            // add all people at the current time

            while(i<n && arrival[i]<=time){
                if(state[i]==1){
                    exitQue.offer(i);
                }else{
                    entryQue.offer(i);
                }
                i++;
            }

            if(!exitQue.isEmpty() && (lastState==1 || entryQue.isEmpty())){
                int idx= exitQue.poll();
                ans[idx]=time;
                lastState=1;
            }else if(!entryQue.isEmpty()){
                int idx= entryQue.poll();
                ans[idx]=time;
                lastState=0;
            }else{
                lastState=1;
            }

            time++;
        }


        return ans;
    }
}