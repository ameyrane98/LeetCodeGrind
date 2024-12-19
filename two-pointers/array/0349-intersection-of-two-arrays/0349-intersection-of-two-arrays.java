class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int p1=0;
        int p2=0;
        HashSet<Integer> arr= new HashSet();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(p1<nums1.length && p2< nums2.length){
            if(nums1[p1]==nums2[p2]){
                arr.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1]<nums2[p2]){
                // find which is samller and incremnet the smalles as both array are sorted, [1,1,2,2] 
                p1++;
            }else{
                p2++;
            }
        }

        int K = arr.size();
        int[] result = new int[K];
        int curr = 0;
        for (int x: arr) {
            result[curr++] = x;
        }

        //Return the result
        return result;
    }
}