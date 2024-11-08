class Solution {
/** Approch using Dp (Memoization) */
    public int solve(int n,int[] store){
        if(n<=1){
            return n;
        }else if(store[n]!=-1){
            return store[n];
        }

        return store[n]=solve(n-1,store)+solve(n-2,store);
    }
    
    public int fib(int n) {
        int[] store = new int[n+1];
        Arrays.fill(store, -1);
        return solve(n,store);
    }

/** normal approach tIME COMPLEXITY O(2^N)*/
    
    // public int fib(int n) {
        
    //     if(n<=1){
    //         return n;
    //     }

    //     return fib(n-1) + fib(n-2);
    // }
}