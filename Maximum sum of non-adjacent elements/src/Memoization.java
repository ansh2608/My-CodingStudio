import java.util.ArrayList;
import java.util.Arrays;

public class Memoization {
    public static int helper(ArrayList<Integer> nums, int i,int[] dp){
        if (i==0) return nums.get(i);
        if (i<0) return 0;
        if (dp[i]!=-1) return dp[i];
        int pick= nums.get(i)+helper(nums,i-2,dp);
        int notPick=helper(nums,i-1,dp);
        dp[i]= Math.max(pick,notPick);
        return dp[i];
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[] dp=new int[nums.size()];
        Arrays.fill(dp,-1);
        return helper(nums,nums.size()-1,dp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> num=new ArrayList<>();
        num.add(2);
        num.add(1);
        num.add(4);
        num.add(9);
        System.out.println(maximumNonAdjacentSum(num));
    }
}
