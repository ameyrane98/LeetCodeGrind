
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for (int[] subImage : image) {
            int start = 0;
            int end = subImage.length - 1;

            while (start <= end) {
                // Swap and invert start and end
                if (start == end) { // Handle the middle element for odd-length arrays
                    subImage[start] = subImage[start] == 0 ? 1 : 0;
                } else {
                    int temp = subImage[start];
                    subImage[start] = subImage[end] == 0 ? 1 : 0;
                    subImage[end] = temp == 0 ? 1 : 0;
                }
                start++;
                end--;
            }
        }
        return image;
    }
}
