class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Approach 1: brute-force algo for O(n^2);
        // int[] arr= new int[temperatures.length];
        // for(int i=0; i<temperatures.length;i++){
        //     int count=0;
        //    for(int j=i+1; j<temperatures.length;j++){
        //         if(temperatures[j]>temperatures[i]){
        //             count=j-i;
        //             arr[i]=count;
        //             break;
        //         }
        //    }
        // }

        // return arr;

        /** Approach 2 */
     
      int[] arr = new int[temperatures.length];  // To store results
      Stack<Integer> stck = new Stack<>();  // Stack to store indices

    // Process from right to left (reverse order)
    for (int i = temperatures.length - 1; i >= 0; i--) {
        // Remove indices from the stack where the temperature is less than or equal to the current temperature
        while (!stck.isEmpty() && temperatures[stck.peek()] <= temperatures[i]) {
            stck.pop();
        }
    
        // If the stack is not empty, the top of the stack is the index of the next warmer day
        // The difference between the current index and the stack's top gives the number of days
        arr[i] = stck.isEmpty() ? 0 : stck.peek() - i;
    
        // Push the current day’s index onto the stack
        stck.push(i);
    }

    return arr;

    }
}