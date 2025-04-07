// class Solution {
//     // O(n log n)
//     public int[] countBits(int n) {
//         int[] ans= new int[n+1];
//         Arrays.fill(ans,-1);
//         //O(n)
//         for(int i=0; i<=n;i++){
//             ans[i]=countBit1s(i);
//         }

//         return ans;
//     }

//     public int countBit1s(int i){
//         //O(log i)
//         int count=0;
       
//         while(i!=0){
//             i= i &(i-1);
//             count++;
//         }

//         return count;
//     }
// }

class Solution {
    // O(n log n)
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        Arrays.fill(ans,-1);
        //O(n)
        ans[0]=0;
        
        for(int i=0; i<=n;i++){
            if(i % 2 !=0){
                ans[i]=ans[i/2]+1;
            }else{
                ans[i]= ans[i/2];
            }
        }

        return ans;
    }

  
}