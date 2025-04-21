class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }

    public boolean solve(int[] arr, int i, boolean[] visited) {
        // Out of bounds or already visited
        if (i < 0 || i >= arr.length || visited[i]) {
            return false;
        }

        // Found a path to 0
        if (arr[i] == 0) {
            return true;
        }

        // Mark as visited
        visited[i] = true;

        // Try both possible jumps
        return solve(arr, i + arr[i], visited) || solve(arr, i - arr[i], visited);
    }

    /** Solution with dp */

//     class Solution {
//     public static boolean finder(int arr[],int index,ArrayList<Integer> lst,Boolean dp[]){
        
//         if(index<0 || index>=arr.length || lst.contains(index)){
//             return false;
//         }
//         if(dp[index]!=null){
//             return dp[index];
//         }
//         if(arr[index]==0){
//             return dp[index]=true;
//         }
        
//         lst.add(index);
//         boolean pick=finder(arr,index+arr[index],lst,dp);
//         boolean npick=finder(arr,index-arr[index],lst,dp);
//         lst.remove(lst.size()-1);
//         return dp[index]=pick||npick;
//     }
//     public boolean canReach(int[] arr, int start) {
//         if(arr[arr.length-1]==0)
//         return true;
//         Boolean dp[]=new Boolean[arr.length];
//         return finder(arr,start,new ArrayList<>(),dp);
//     }
// }

}
