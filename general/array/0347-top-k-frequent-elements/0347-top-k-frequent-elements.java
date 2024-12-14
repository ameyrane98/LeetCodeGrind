class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**Approach 1 using minHeap */
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int[] result= new int[k];
        // PriorityQueue<Map.Entry<Integer,Integer>> minHeap= new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());

        // for(int n : nums){
        //     map.put(n,map.getOrDefault(n,0)+1);
        // }

        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     minHeap.add(entry);
        //     if(minHeap.size()>k){
        //         minHeap.poll();
        //     }
        // }
        // int i=0;
        // while(!minHeap.isEmpty()){
        //     result[i++]=minHeap.poll().getKey();
        // }

        // return result;

        /** Approach 2 using bucket sort*/
        // An array whose index is the frequecny number i.e arr[2]= is a number which has frequency(number of time) 2.
        // length of array is  of nums.length+1 i.e nums.length[6] then there can we worst case array as nums[1,1,1,1,1,1]
        List<List<Integer>> freqarr= new ArrayList(nums.length+1);
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result= new int[k];
        for(int i=0;i<nums.length+1;i++){
            freqarr.add(new ArrayList());
        }
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        for(int key: map.keySet()){
            freqarr.get(map.get(key)).add(key);
        }

        int j=0;
       //Pick element from right to left, because index rightmost has max frequencey
        for (int i = nums.length; i >= 0 && j < k; i--) {
            for (int num : freqarr.get(i)) {
                if (j < k) {
                    result[j++] = num;
                }
            }
        }

        return result;
    }
}