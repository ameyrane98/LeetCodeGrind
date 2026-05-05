class Solution {
   
    public int numTrees(int n) {
        /** Idea
            I pick a root. That splits the remaining nodes into left shape and right shape
            then from that shapes i again pick a root and build the tree in left shape and right shape.
            then return the sum += numTrees(leftShape)*numsTrees(rightShape)

         */

        if(n == 0 || n==1){
            //Empty Tree or just one node
            return 1;
        }
        int sum =0;
        for(int i =1; i<=n; i++){
            
            sum+=numTrees(i-1) * numTrees(n-i);
        }

        return sum;
    }
}