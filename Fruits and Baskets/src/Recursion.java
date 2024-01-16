import java.util.ArrayList;

public class Recursion {
    public static int helper(ArrayList<Integer> basket, int start,int end){
        if(start>end) return 0;
        int kevin = basket.get(start)+Math.min(helper(basket,start+2,end),helper(basket,start+1,end-1));
        int mark = basket.get(end)+Math.min(helper(basket,start+1,end-1),helper(basket,start,end-2));
        return Math.max(kevin,mark);
    }
    public static int getMaxFruits(ArrayList<Integer> basket, int n){
        return helper(basket,0,n-1);
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
