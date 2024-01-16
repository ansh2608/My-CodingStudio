public class Recursion {
    public static int helper(int[] houses,int i){
        if (i==0) return houses[i];
        if (i<0) return 0;
        int pick=houses[i]+helper(houses,i-2);
        int leave=helper(houses,i-1);
        return Math.max(pick,leave);
    }
    public static int maxMoneyLooted(int[] houses) {
        return helper(houses,houses.length-1);
    }
    public static void main(String[] args) {
        int[] houses={5,5,10,100,10,5};
        System.out.println(maxMoneyLooted(houses));
    }
}
