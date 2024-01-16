import java.util.ArrayList;

public class Tabulation {
    public static int getMaxFruits(ArrayList<Integer> basket, int n){
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = basket.get(i);
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                int kevinPickStart = basket.get(start) + Math.min((start + 2 <= end) ? dp[start + 2][end] : 0, (start + 1 <= end - 1) ? dp[start + 1][end - 1] : 0);
                int markPickEnd = basket.get(end) + Math.min((start + 1 <= end - 1) ? dp[start + 1][end - 1] : 0, (start <= end - 2) ? dp[start][end - 2] : 0);
                dp[start][end] = Math.max(kevinPickStart, markPickEnd);
            }
        }
        return dp[0][n - 1];
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
