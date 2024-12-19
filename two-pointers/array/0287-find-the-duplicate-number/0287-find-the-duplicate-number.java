class Solution {
    public int findDuplicate(int[] nums) {
        // using Floyd's Tortoise amd Haire problem

        int slow= nums[0];
        int fast= nums[0];


        //first loop detemined the presence of the cycle
        while(true){
            slow=nums[slow];
            fast= nums[nums[fast]];

            if(slow==fast){
                break;
            }
        }

        // second loop determint the starting point of the cycle
        int slow2 = nums[0];

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        
          return slow;  
    //O(n^2)- brute force iterates for every element
    //     int left=0;
    //     int right=0;

    //     while(left<nums.length){
    //         if(right>=nums.length){
    //             left++;
    //             right=0;
    //         }

    //         if(left!=right && nums[left]==nums[right]){
    //             return nums[right];
    //         }

    //         right++;
    //     }

    //     return nums[right];
    // }
    }
}