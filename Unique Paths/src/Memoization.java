public class Memoization {
    public static int helper(int m, int n,int[][] dp){
        if (m==0 && n==0) return 1;
        if (m<0 || n<0) return 0;
        if (dp[m][n]!=0) return dp[m][n];
        int left=helper(m-1,n,dp);
        int up=helper(m,n-1,dp);
        return dp[m][n]=left+up;
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        return helper(m,n,dp);
    }
    public static void main(String[] args) {
        int m=2,n=2;
        System.out.println(uniquePaths(m,n));
    }
}
