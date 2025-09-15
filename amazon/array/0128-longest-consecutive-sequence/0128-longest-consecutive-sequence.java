

import static java.lang.Math.max;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums ==null){
            return 0;
        }

        int[] parent = new int[nums.length];
        int[] rank = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            parent[i]=i;
            rank[i]=0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            map.put(nums[i],i); // to retrieve index on O(1)
        }

        for(int num : nums){
            if(map.containsKey(num+1)){
                union(map.get(num),map.get(num+1),parent,rank);
            }else if(map.containsKey(num-1)){
                union(map.get(num),map.get(num-1),parent,rank);
            }
        }

        int[] freq = new int[nums.length];
        Arrays.fill(freq,0);
        int maxLength=0;

        for (int i = 0; i < nums.length; i++) {
            int root = find(i,parent);
            freq[root]++;
            maxLength = Math.max(maxLength,freq[root]);
        }

        return maxLength;
    }


    int find(int x, int[] parent) {
            if (parent[x] != x) {
                parent[x] = find(parent[x], parent); // Path compression
            }
            return parent[x];
        }

    void union(int a, int b, int[] parent, int[] rank) {
            int rootA = find(a, parent);
            int rootB = find(b, parent);

           if(rootA!=rootB){
                if(rank[rootA]>rank[rootB]){
                    parent[rootB]=rootA;
                }else if(rank[rootA]<rank[rootB]){
                    parent[rootA]=rootB;
                }else{
                    parent[rootA]=rootB;
                    rank[rootB]++;
                }
           }
    }
}