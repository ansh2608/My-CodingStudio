
public class Optimal {
    public static int frogJump(int n, int[] heights) {
        int p=0,pp=0;
        for (int i=1;i<n;i++){
            int fs=p+Math.abs(heights[i]-heights[i-1]);
            int ss=Integer.MAX_VALUE;
            if (i>1) ss=pp+Math.abs(heights[i]-heights[i-2]);
            int curr=Math.min(fs,ss);
            pp=p;
            p=curr;
        }
        return p;
    }
    public static void main(String[] args) {
        int n=4;
        int[] heights ={10, 20, 30, 10};
        System.out.println(frogJump(n,heights));
    }
}
