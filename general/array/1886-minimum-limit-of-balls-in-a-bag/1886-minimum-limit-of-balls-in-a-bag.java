class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        /**
            We can use brute force to see each options of spliting a number in the array
            i.e [7,17] for MaxOps=2

            if split is 1 then 7-->1-->6 ops =1,   17-->1 --> 16 here the min penalty is 17
            So as we try each number 1 to 17 beacuse 17 is maxspace we will come acrros a desire split such as 17--> 7--> 10, which in second ops
            becomes [7,7,3]

            hence, rather than linear trying each split 1,2,...17
            we do bianry search to find perfect split
         */

        int left =1;
        int right= Arrays.stream(nums).max().getAsInt();// max of the list. because it's biggest penaltya and we need to minimize it
        int result=right;  // initially the result is the max element
        


        while(left<=right){
            int mid= left+(right-left)/2;
            if(ispossible(nums,maxOperations, mid)){
            result=mid; // possible ans
            right=mid-1; // going to smaller value

            }else{
                left=mid+1;
            }
        }
        

        return result;
    }


    boolean ispossible(int[] nums, int maxOps, int mid){
           int totalOps = 0; // To bring each number <= mid

        for (int num : nums) {
            int ops = num / mid;// total number of opeartion in general if number is divisible by maxOps

            if (num % mid == 0) {
                ops -= 1;
            }

            totalOps += ops;
        }

        return totalOps <= maxOps;
    }

}