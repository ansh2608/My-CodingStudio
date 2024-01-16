import java.util.ArrayList;

public class Recursion {
    public static int helper(ArrayList<Integer> nums,int i){
        if (i==0) return nums.get(i);
        if (i<0) return 0;
        int pick= nums.get(i)+helper(nums,i-2);
        int notPick=helper(nums,i-1);
        return Math.max(pick,notPick);
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return helper(nums,nums.size()-1);
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
