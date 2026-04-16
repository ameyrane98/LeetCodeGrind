class Solution {
    public int minOperations(String s) {
        int cost1 =0;
        int n = s.length();
        for(int i=0; i<s.length() ; i++){
            char expected = i%2 == 0 ? '0':'1';        // what should Pattern1 have at index i?
            if (s.charAt(i) != expected) {
                cost1++;
            }
        }

        int cost2= n-cost1;

        return Math.min(cost1,cost2);
    }
}