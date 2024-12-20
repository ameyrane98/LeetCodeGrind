class Solution {
    public int trap(int[] height) {
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