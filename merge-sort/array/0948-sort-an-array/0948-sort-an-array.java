class Solution {

    /**quick sort, Altough it fails because worst case is O(n^2), best case is when array is partitioned correctly in half then O(nlogn) */
    // public int[] sortArray(int[] nums) {
    //     quickSort(nums,0,nums.length-1);   
    //     return  nums;
    // }

    // void quickSort(int[] nums, int low, int high){
    //     if(low>=high){
    //         return;
    //     }

  
    //     int ParI= partition(nums,low,high);

    //     quickSort(nums,low,ParI-1);
    //     quickSort(nums,ParI+1,high);
        
    // }

    // int partition(int[] nums, int low, int high){
    //     int pivotIndex=low;
    //     int pivot=nums[high];

    //     for(int i=low;i<high;i++){
    //         if(nums[i]<=pivot){
    //             swap(nums,i,pivotIndex);
    //             pivotIndex++;
    //         }
    //     }

    //     swap(nums,pivotIndex,high);

    //     return pivotIndex;
    // }

    // void swap(int[] nums, int a, int b){
    //     int temp=nums[a];
    //     nums[a]=nums[b];
    //     nums[b]=temp;
    // }


    /**Merge Sort */
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