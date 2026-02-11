class Solution {
    public int[] getConcatenation(int[] nums) {

        if (nums == null) return null; // or return new int[0];

        int n = nums.length;
        int[] result = new int[n * 2];

        System.arraycopy(nums, 0, result, 0, n);
        System.arraycopy(nums, 0, result, n, n);

        return result;
    }
}