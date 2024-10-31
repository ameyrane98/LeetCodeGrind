class Solution {
    public int maxProfit(int[] prices) {
        int buy= 0;
        int sell=1;
        int maxProfit=0;
        int profit=0;
        while(sell < prices.length){
            if(prices[buy]<prices[sell]){
                profit=prices[sell]-prices[buy];
                maxProfit= Math.max(maxProfit,profit);
            }else{
                buy=sell;
            }
            sell++;
        }

        return maxProfit;
    }
}