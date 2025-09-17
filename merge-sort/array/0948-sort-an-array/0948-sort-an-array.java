class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        divide(nums,0,nums.length-1);
        return nums;
    }
    public void divide(int[] nums,int l, int r){
        if(l>=r){
            return;
        }
        int mid = l +(r-l)/2;
        divide(nums, l,mid);
        divide(nums, mid+1,r);

        merge(nums,l,mid,r);
    }

    public void merge(int[] nums,int l,int m, int r){
        int l_len= m-l+1;
        int r_len= r-m;

        int[] left = new int[l_len];
        int[] right = new int[r_len];
        int k=l;

        for(int i=0; i<l_len; i++){
            left[i]=nums[k];
            k++;
        }
        for(int j=0; j<r_len; j++){
            right[j]=nums[k];
            k++;
        }

        int i=0; int j=0;k=l;

        while(i<l_len && j<r_len){
            if(left[i]<=right[j]){
                nums[k]=left[i];
                i++;
                k++;
            }else{
                nums[k]=right[j];    
                j++;
                k++;
            }
        }

        while(i< l_len){
            nums[k]=left[i];
            i++;
            k++;
        }
        
        while(j< r_len){
            nums[k]=right[j];
            j++;
            k++;
        }
        
       
    }
}