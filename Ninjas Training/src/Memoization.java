public class Memoization {
    public static int helper(int day,int last,int[][] points,int[][] dp){
        if (day==0){
            int max=0;
            for (int task=0;task<3;task++) {
                if (task!=last) max=Math.max(max,points[0][task]);
            }
            return max;
        }
        if (dp[day][last]!=-1) return dp[day][last];
        int max=0;
        for (int task=0;task<3;task++) {
            if (task!=last) {
                int point=points[day][task]+helper(day-1,task,points,dp);
                max=Math.max(max,point);
            }
        }
        return dp[day][last]=max;

    }
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp=new int[points.length][points[0].length];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        }
        return helper(n-1,3,points,dp);
    }
    public static void main(String[] args) {
        int n=3;
        int[][] points={{10,40,70},{20,50,80},{30,60,90}};
        System.out.println(ninjaTraining(n,points));
    }
}
