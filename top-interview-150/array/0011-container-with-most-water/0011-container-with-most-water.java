class Solution {
    public int maxArea(int[] height) {
        int ptr_1=0;
        int ptr_2=height.length-1;
        int max_area=0;
        while(ptr_1<ptr_2){
            if(height[ptr_1]<height[ptr_2]){
                max_area= Math.max(max_area,height[ptr_1]* (ptr_1 - ptr_2));
                ptr_1+=1;
            }else{
                max_area= Math.max(max_area,height[ptr_2]* (ptr_1 - ptr_2));
                ptr_2-=1;
            }
        }

        return max_area;
    }
}