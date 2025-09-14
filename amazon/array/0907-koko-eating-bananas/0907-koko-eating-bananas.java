class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low= 1; int high = piles[n-1];
        int ans = high;
        while(low<high){
            int mid = low + (high - low) /2;
            int hours=0;
            for(int pile: piles){
                 hours += (pile + mid - 1) / mid;
                if (hours > h) break;
            }

            if(hours<=h){
                ans=mid;
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return ans;

    }
}