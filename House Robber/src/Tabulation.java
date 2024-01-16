
public class Tabulation {
    public static int maxMoneyLooted(int[] houses) {
        int n=houses.length,prev=houses[0],prev2=0;
        for (int i=1;i<n;i++){
            int pick=houses[i];
            if (i>1) pick+=prev2;
            int leave=prev;
            int curr=Math.max(pick,leave);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] houses={5,5,10,100,10,5};
        System.out.println(maxMoneyLooted(houses));
    }
}
