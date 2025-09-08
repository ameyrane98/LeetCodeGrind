class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        int original = image[sr][sc];
        if (original == color) return image; 
      
        solve(image, sr, sc,original,color);

        return image;
    }

    public void solve(int[][] image, int i, int j,int ogcolor, int color){
        int m = image.length;
        int n = image[0].length;

        if(i<0 || j<0 || i>=m || j>=n || image[i][j]!=ogcolor){
            return;
        }
        
        image[i][j]=color;

        solve(image,i-1,j,ogcolor,color);
        solve(image,i+1,j,ogcolor,color);
        solve(image,i,j-1,ogcolor,color);
        solve(image,i,j+1,ogcolor,color);
    }
}