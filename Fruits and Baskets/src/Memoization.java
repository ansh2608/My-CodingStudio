import java.util.ArrayList;

public class Memoization {
    public static int helper(ArrayList<Integer> basket, int start,int end,int[][] dp){
        if(start>end) return 0;
        if(dp[start][end]!=0) return dp[start][end];
        int kevin = basket.get(start)+Math.min(helper(basket,start+2,end,dp),helper(basket,start+1,end-1,dp));
        int mark = basket.get(end)+Math.min(helper(basket,start+1,end-1,dp),helper(basket,start,end-2,dp));
        return dp[start][end]=Math.max(kevin,mark);
    }
    public static int getMaxFruits(ArrayList<Integer> basket, int n){
        int[][] dp=new int[n][n];
        return helper(basket,0,n-1,dp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> basket=new ArrayList<>();
        int n=4;
        basket.add(5);
        basket.add(8);
        basket.add(2);
        basket.add(1);
        System.out.println(getMaxFruits(basket,n));
    }
}
