class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l=1;
        int r= piles[piles.length-1];
        while(l<r){
            int mid= l+(r-l)/2;

            if(canEatAllBananas(piles,h,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    boolean canEatAllBananas(int[] piles, int hr, int bananPrHr){
        int countHr=0;
        for(int p: piles){
           countHr += (p + bananPrHr - 1) / bananPrHr; // Efficient division
            if (countHr > hr) return false; // Early exit for optimization
        }

        return countHr<=hr;
    }
}