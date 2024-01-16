import java.util.ArrayList;

public class Space_optimize {
    public static int getMaxFruits(ArrayList<Integer> basket, int n) {
        int[] dpPrev = new int[n];
        int[] dpCurr = new int[n];
        for (int i = 0; i < basket.size(); i++) dpCurr[i] = basket.get(i);
        for (int len = 2; len <= n; len++) {
            int[] temp = dpPrev;
            dpPrev = dpCurr;
            dpCurr = temp;
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                int kevin = basket.get(start) + Math.min((start + 2 <= end) ? dpPrev[start + 2] : 0, (start + 1 <= end - 1) ? dpPrev[start + 1] : 0);
                int mark = basket.get(end) + Math.min((start + 1 <= end - 1) ? dpPrev[start + 1] : 0, (start <= end - 2) ? dpPrev[start] : 0);
                dpCurr[start] = Math.max(kevin, mark);
            }
        }
        return dpCurr[0];
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
