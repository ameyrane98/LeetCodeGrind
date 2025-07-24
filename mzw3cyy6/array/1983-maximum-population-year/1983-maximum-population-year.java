class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[2051-1950];
       
         for (int[] log : logs) {
            arr[log[0] - 1950]++;  // +1 at birth year
            arr[log[1] - 1950]--;  // -1 at death year
        }


        int currPop=0;
        int earlyYear=1950;
        int maximumPopulation=0;

        for(int i=0; i<arr.length; i++){
            currPop+=arr[i];
            if(currPop>maximumPopulation){
                maximumPopulation=currPop;
                earlyYear=1950+i;
            }
        }

        return earlyYear;
    }
}