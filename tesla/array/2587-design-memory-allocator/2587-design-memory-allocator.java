class Allocator {


/**
 * 
    arr[10];
    arr[1,...] => (1,1) 
    1->[0th index] space (1,1) 1->1. 
    2->[1st Index] space (1,2) 2->1
    3->[2nd Index] space (1,3) 3->0
    4->[3rd Index] space (3,4) 4->4
    free 2 [1,_, 3,_,_,_,_,_,_,_]
  

    1->[0th index] space (1,1)
    2->[]
    3->[2nd Index] space (1,3)

    allocate (3,4)


 */

    int[] arr;
    HashMap<Integer, ArrayList<int[]>> map;
    public Allocator(int n) {
        arr = new int[n];
        map = new HashMap<>();
        Arrays.fill(arr,0);
    }
    
    public int allocate(int size, int mID) {
        int countZero=0;
    
        for(int i=0; i<arr.length ;i++){
            if (arr[i] == 0) {
                countZero++;
            
                if(countZero == size){
                    int startIndex= i-size + 1;

                    for(int j=startIndex; j<=i; j++){
                        arr[j]=mID;
                    }

                   int[] block = new int[]{startIndex,size};
                            if (map.containsKey(mID)) {
                                map.get(mID).add(block); // Add this new block to the ex
                            } else {
                                ArrayList<int[]> data = new ArrayList<>();
                                data.add(block); // Add the first block to a new list
                                map.put(mID, data);
                            }
                    
                    
                    return startIndex;
                }
            }else{
                countZero=0;
            }
        }
       
        
      return -1;
    }
    
    public int freeMemory(int mID) {
        int totalCounter =0;
        if(map.containsKey(mID)){
            for(int[] block : map.get(mID)){
                int index= block[0];
                int size= block[1];

                for(int k=index; k<= size+index-1; k++){
                    arr[k]=0;
                    totalCounter++;
                }


            }

            map.remove(mID);
        }
        
        return totalCounter;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */