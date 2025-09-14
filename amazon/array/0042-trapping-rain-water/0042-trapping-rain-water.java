class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water=0;
        int leftMax=0;
        int rightMax=0;

        int l=0; int r= n-1;

        while(l<r){
            if(height[l]<height[r]){
                if(leftMax<=height[l]){
                    leftMax= height[l];
                }else{
                    water+= leftMax-height[l];
                }
                l++;
            }else{
                if(rightMax<=height[r]){
                    rightMax= height[r];
                }else{
                    water+= rightMax-height[r];
                }
                r--;
            }
        }

        return water;

    }
}