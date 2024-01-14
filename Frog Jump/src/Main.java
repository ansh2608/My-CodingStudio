import java.util.Arrays;

public class Main {
    public static int helper(int[] heights,int n,int[] dp){
        if(n==0) return 0;
        if (dp[n]!=0) return dp[n];
        int left=helper(heights, n-1,dp)+Math.abs(heights[n]-heights[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1) right=helper(heights, n-2,dp)+Math.abs(heights[n]-heights[n-2]);
        dp[n]=Math.min(left, right);
        return dp[n];
    }
    public static int frogJump(int n, int[] heights) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        return helper(heights,n-1,dp);
    }
    public static void main(String[] args) {
        int n=4;
        int[] heights ={10, 20, 30, 10};
        System.out.println(frogJump(n,heights));
    }
}