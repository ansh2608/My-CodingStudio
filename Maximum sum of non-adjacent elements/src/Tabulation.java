import java.util.ArrayList;

public class Tabulation {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n= nums.size(),p=nums.get(0),pp=0;
        for (int i=1;i<n;i++){
            int take=nums.get(i);
            if (i>1) take+=pp;
            int leave=p;
            int curr=Math.max(take,leave);
            pp=p;
            p=curr;
        }
        return p;
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
