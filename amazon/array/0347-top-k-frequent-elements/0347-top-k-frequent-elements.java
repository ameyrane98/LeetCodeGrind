class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        HashMap<Integer, Integer> hmap= new HashMap<>();
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> e : hmap.entrySet()) {
            pq.offer(new int[]{e.getValue(), e.getKey()}); // {freq, num}
        }

       while (k != 0 && !pq.isEmpty()) {
            int[] data = pq.poll();
            result.add(data[1]); // number
            k--;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}