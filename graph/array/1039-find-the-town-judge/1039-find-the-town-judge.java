class Solution {
    public int findJudge(int n, int[][] trust) {
        // find a node with 0 outdegree and n-1 indegree (i.e everybody trust it), we are good.

        int[] nodesInDeg = new int[n+1];
        int[] nodesOutDeg = new int[n+1];

        for(int[] tru : trust){
            nodesInDeg[tru[1]]++;
            nodesOutDeg[tru[0]]++;

        }

        for(int i=1; i<=n;i++){
            if( nodesInDeg[i]==n-1 && nodesOutDeg[i]==0){
                return i;
            }
        }

        System.out.println(Arrays.toString( nodesOutDeg));

        return -1;
    }
}