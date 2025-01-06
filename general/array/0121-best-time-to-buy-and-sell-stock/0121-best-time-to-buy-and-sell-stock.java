class Solution {
    public int maxProfit(int[] prices) {
        int buyPtr=0;
        int sellPtr=1;
        int profit=0;
        int max_profit= 0;
        while(sellPtr<prices.length){
            
            if(prices[buyPtr]<prices[sellPtr]){
                profit=prices[sellPtr]-prices[buyPtr];
                max_profit=Math.max(max_profit,profit);
            }else{
                buyPtr=sellPtr;
            }

         
            sellPtr++;
        }

        return max_profit;
    }
}