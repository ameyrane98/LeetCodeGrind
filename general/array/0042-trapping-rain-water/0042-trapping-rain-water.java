class Solution {
    public int trap(int[] height) {
        /**
            You can solve this by stack, Dp and two pointer. Below is tow pointer approach
         */

         /**
            The Intution is that water collected between two building= leftMaxiumHeightBuiding-rightMaxiumHeightBuiding- CurrentbuildigHeight 
            also, we increment left++ if leftMax<rightMax and vise versa
            Explanation link : https://yuminlee2.medium.com/leetcode-42-trapping-rain-water-d158e4af53d3#:~:text=Use%20two%20pointers%20technique%20by%20starting%20left%20and%20right%20pointers,is%20lower%2C%20advance%20right%20pointer.
          */
        int left=0;
        int right=height.length-1;
        int leftMax=height[left];
        int rightMax= height[right];
        int water=0;
        while(left<right){
            if(leftMax<rightMax){
                left+=1;
                leftMax= Math.max(leftMax,height[left]);
                water+=leftMax-height[left];
            }else{
                right-=1;
                rightMax= Math.max(rightMax,height[right]);
                water+=rightMax-height[right];
            }
        }

        return water;
    }
}