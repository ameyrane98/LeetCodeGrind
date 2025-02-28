class Solution {
    PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
    public int findKthLargest(int[] nums, int k) {
        for(int num : nums){
            pq.add(num);
        }

        while(k>1){
            pq.poll();
            k--;
        }
   
        return pq.peek();
    }
}