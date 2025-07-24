class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
       Arrays.sort(ranges,(a,b)->a[0]-b[0]);

       for(int[] range: ranges){
            if(range[0]>left){
                return false;
            }else if (range[1] >= left){
                left=range[1]+1;
                if(left>right){
                    return true;
                }
            }
       }

        return left>right;
    }
}