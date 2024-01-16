import java.util.Arrays;

public class Memoization {
    public static int helper(int[] houses,int i,int[] dp){
        if (i==0) return houses[i];
        if (i<0) return 0;
        if (dp[i]!=-1) return dp[i];
        int pick=houses[i]+helper(houses,i-2,dp);
        int leave=helper(houses,i-1,dp);
        return dp[i]=Math.max(pick,leave);
    }
    public static int maxMoneyLooted(int[] houses) {
        int n=houses.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(houses,n-1,dp);
    }
    public static void main(String[] args) {
        int[] houses={5,5,10,100,10,5};
        System.out.println(maxMoneyLooted(houses));
    }
}
