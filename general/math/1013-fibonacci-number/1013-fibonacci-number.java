class Solution {
/** Approch using Dp Bottom-up Approach Time O(n)*/
    public int fib(int n) {
        int[] store = new int[n+1];
        Arrays.fill(store,-1);
        if(n<=1){
            return n;
        }

        store[0]=0;
        store[1]=1;

        for(int i=2; i<=n;i++){
            store[i]=store[i-1]+store[i-2];
        }

        return store[n];
    }

/** Approch using Dp (Memoization) Top Down Approach */
    // public int solve(int n,int[] store){
    //     if(n<=1){
    //         return n;
    //     }else if(store[n]!=-1){
    //         return store[n];
    //     }

    //     return store[n]=solve(n-1,store)+solve(n-2,store);
    // }
    
    // public int fib(int n) {
    //     int[] store = new int[n+1];
    //     Arrays.fill(store, -1);
    //     return solve(n,store);
    // }

/** normal approach TIME COMPLEXITY O(2^N)*/
    
    // public int fib(int n) {
        
    //     if(n<=1){
    //         return n;
    //     }

    //     return fib(n-1) + fib(n-2);
    // }
}