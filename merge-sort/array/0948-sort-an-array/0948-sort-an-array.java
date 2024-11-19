class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);   
        return  nums;
    }

    void mergeSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }

        int m = l + (r-l) /2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,r);

        merge(nums,l,m,r);
    }

    void merge(int[] nums, int l, int m, int r){
        int lsize= m-l+1;
        int rsize= r-m;

        int[] larr=new int[lsize];
        int[] rarr=new int[rsize];
        int k =l;
 
        for(int i=0; i<lsize; i++){
            larr[i] = nums[k++];
        }
        
        for(int j=0; j<rsize; j++){
            rarr[j] = nums[k++];
        }

        k=l;
        int i=0, j=0;
        while(i< lsize && j < rsize){
            if(larr[i]<=rarr[j]){
                nums[k++]=larr[i++];
            }else{
                nums[k++]=rarr[j++];
            }
        }


        while(i<lsize){
            nums[k++]=larr[i++];
        }

        
        while(j<rsize){
            nums[k++]=rarr[j++];
        }
    }


}