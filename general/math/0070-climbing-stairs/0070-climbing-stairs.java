class Solution {
   int[] arr = new int[46];
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        // Arrays.fill(arr,-1);
        return solve(n);
    }

    public int solve(int n){
        arr[1]=1;
        arr[2]=2;

        if(n<=2){
            return arr[n];
        }

        for(int i=3; i<=n ; i++){
            arr[i]= arr[i-1]+ arr[i-2];
        }
       

        return arr[n];
    }
}