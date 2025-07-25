class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]); // sort by right values;
        int lastEnd= Integer.MIN_VALUE;
        int counter=0;
        for(int[] pair: pairs){
            int start= pair[0];
            int end= pair[1];

            if(start>lastEnd){
                counter++;
                lastEnd=end;
            }
        }

        return counter;

    }
}