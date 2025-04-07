class Solution {
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        Arrays.fill(ans,-1);
        for(int i=0; i<=n;i++){
            ans[i]=countBit1s(i);
        }

        return ans;
    }

    public int countBit1s(int i){
        int count=0;
       
        while(i!=0){
            i= i &(i-1);
            count++;
        }

        return count;
    }
}