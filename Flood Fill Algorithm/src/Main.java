public class Main {
    public static void dfs(int x,int y,int[][] image,int[][] ans,int p,int[] delRow,int[] delCol,int inColor){
        ans[x][y]=p;
        int n=image.length,m=image[0].length;
        for(int i=0;i<4;i++){
            int row=x+delRow[i];
            int col=y+delCol[i];
            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==inColor && ans[row][col]!=p){
                dfs(row,col,image,ans,p,delRow,delCol,inColor);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        int inColor=image[x][y];
        int[][] ans=image;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        dfs(x,y,image,ans,newColor,delRow,delCol,inColor);
        return ans;
    }
    public static void main(String[] args) {
        int x=2,y=2,p=5;
        int[][] image={ {7, 1, 1, 1}, {1, 7, 7, 7}, {7, 7, 7, 0},{7, 7, 7, 4},{4, 4, 4, 4}};
        int[][] ans=floodFill(image,x,y,p);
        for (int i=0;i< ans.length;i++){
            for (int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}