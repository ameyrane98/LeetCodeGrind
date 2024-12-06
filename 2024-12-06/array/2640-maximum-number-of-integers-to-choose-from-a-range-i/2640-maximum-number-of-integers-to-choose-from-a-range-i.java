class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Step 1: Create a HashSet of banned numbers within range
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            if (num <= n) {
                bannedSet.add(num);
            }
        }

        // Step 2: Iterate from 1 to n and calculate the maximum count
        int currentSum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            // Skip if the number is banned or exceeds maxSum when added
            if (bannedSet.contains(i) || currentSum + i > maxSum) {
                continue;
            }
            currentSum += i;
            count++;
        }

        return count;
    }
    // This works in O(n)
    // public int maxCount(int[] banned, int n, int maxSum) {
    //     int result=0;
    //     int count=0;
    //       HashSet<Integer> arr= new HashSet<Integer>();
    //     for(int i=0; i<banned.length;i++){
    //         if(banned[i]<=n){
    //             arr.add(banned[i]);
    //         }
           
    //     }

        
    //     System.out.println(arr);
    //     for(int j=1; j<=n;j++){
    //         if(arr.contains(j)){
    //          // number is banned
    //             continue;
    //         }
         
    //         if(result+j<=maxSum){
    //             result+=j;
    //             count+=1;
    //         }else{
    //             break;
    //         }
    //     }

    //     return count;
    // }
}