class Solution {
/** Solution 1: Bottom up apporach */
//    int[] arr = new int[46];
//     public int climbStairs(int n) {
//         if(n<=2){
//             return n;
//         }
//         // Arrays.fill(arr,-1);
//         return solve(n);
//     }

//     public int solve(int n){
//         arr[1]=1;
//         arr[2]=2;

//         if(n<=2){
//             return arr[n];
//         }

//         for(int i=3; i<=n ; i++){
//             arr[i]= arr[i-1]+ arr[i-2];
//         }
       

//         return arr[n];
//     }

/** Solution 2: Top Down apporach */
    // int[] memo = new int[46];
    // public int climbStairs(int n) {
    //     if(n<=2){
    //         return n;
    //     }

    //     if(memo[n]!=0){
    //         return memo[n];
    //     }

    //     memo[n] = climbStairs(n-1)+climbStairs(n-2);
    //     return memo[n];
    // }
/** Solution 3: Space optimized*/
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev1 = 2, prev2 = 1, curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

}